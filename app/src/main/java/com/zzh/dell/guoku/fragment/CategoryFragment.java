package com.zzh.dell.guoku.fragment;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.zzh.dell.guoku.R;
import com.zzh.dell.guoku.activity.CategoryActivity;
import com.zzh.dell.guoku.activity.SearchActivity;
import com.zzh.dell.guoku.activity.UserBaseActivity;
import com.zzh.dell.guoku.activity.WebActivity;
import com.zzh.dell.guoku.adapter.CategoryADAdapter;
import com.zzh.dell.guoku.adapter.CategoryEntityAdapter;
import com.zzh.dell.guoku.adapter.CategoryImageTextAdapter;
import com.zzh.dell.guoku.bean.Account;
import com.zzh.dell.guoku.bean.CategoryMainBean;
import com.zzh.dell.guoku.callback.HttpCallBack;
import com.zzh.dell.guoku.config.Contants;
import com.zzh.dell.guoku.utils.GsonUtils;
import com.zzh.dell.guoku.utils.SearchDBManager;
import com.zzh.dell.guoku.utils.StringUtils;
import com.zzh.dell.guoku.utils.http.HttpUtils;
import com.zzh.dell.guoku.view.CustomMeasureGridView;
import com.zzh.dell.guoku.view.CustomMeasureListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements HttpCallBack {

    CategoryMainBean mainBean;
    Boolean isSearch = false;
    private SearchDBManager helper;
    private SQLiteDatabase db;
    private BaseAdapter adapter;

    @BindView(R.id.category_view_pager)
    AutoScrollViewPager autoScrollViewPager;

    @BindView(R.id.category_user_pager)
    LinearLayout userPager;

    @BindView(R.id.category_category_pager)
    LinearLayout categoryPager;

    @BindView(R.id.category_category_scrollview)
    HorizontalScrollView categoryScrollview;

    @BindView(R.id.category_user_scrollview)
    HorizontalScrollView userScrollview;

    @BindView(R.id.category_entity_grid)
    CustomMeasureGridView entityGrid;

    @BindView(R.id.category_imagetext_list)
    CustomMeasureListView imagetextList;

    @BindView(R.id.category_scrollview)
    ScrollView scrollView;

    @BindView(R.id.category_search_edit)
    EditText editText;

    @BindView(R.id.category_cancel)
    TextView tv_cancel;

    @BindView(R.id.category_img_delete)
    ImageView img_delete;

    @BindView(R.id.category_history)
    LinearLayout history_linear;


    @BindView(R.id.listView)
    ListView historyListView;

    @OnClick(R.id.tv_clear)
    void clearSearchHistory(){
        helper.deleteData(db);
        querryHistory("");
    }

    @BindView(R.id.search_background)
    View search_background;

    @OnClick(R.id.category_cancel)
    void cancel() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        editText.setText("");
        editText.clearFocus();
    }

    @OnClick(R.id.category_img_delete)
    void delete() {
        editText.setText("");
    }

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.setCallBack(this);
        Map<String, String> map = new TreeMap<>();
        String str = StringUtils.getGetUrl(Contants.CATEGORY_MAIN_PATH, map);
        httpUtils.getStrGET("CategoryFragment", str);

        initSearchView();

        return view;
    }

    private void querryHistory(String string) {
        Cursor cursor = helper.queryData(string);
        // 创建adapter适配器对象
        adapter = new SimpleCursorAdapter(getActivity(), android.R.layout.simple_list_item_1, cursor, new String[]{"name"},
                new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        // 设置适配器
        historyListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initSearchView() {
        helper = SearchDBManager.getManager(getActivity());
        querryHistory("");

        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return isSearch;
            }
        });

        categoryScrollview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return isSearch;
            }
        });

        userScrollview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return isSearch;
            }
        });

        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();

        editText.clearFocus();

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {// 修改回车键功能
                    String search = editText.getText().toString();
                    if ("".equals(search)) {
                        Toast.makeText(getActivity(), "请输入你要搜索的内容", Toast.LENGTH_SHORT).show();
                    } else {
                        editText.clearFocus();
                        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        if (imm.isActive()) {
                            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                        }

                        boolean hasData = helper.hasData(editText.getText().toString());
                        if (!hasData) {
                            helper.insertData(db, editText.getText().toString());
                            querryHistory("");
                        }

                        Intent intent = new Intent(getActivity(), SearchActivity.class);
                        intent.putExtra("search", search);
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.alpha_in, R.anim.no_anim);
                    }
                    return true;
                }
                return false;
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String tempName = editText.getText().toString();
                // 根据tempName去模糊查询数据库中有没有数据
                querryHistory(tempName);
            }
        });

        historyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                String search = textView.getText().toString();
                editText.setText(search);
                editText.setSelection(editText.getText().length());
                editText.clearFocus();
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.putExtra("search", search);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.alpha_in, R.anim.no_anim);
            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    isSearch = true;
                    history_linear.setVisibility(View.VISIBLE);
                    tv_cancel.setVisibility(View.VISIBLE);
                    img_delete.setVisibility(View.VISIBLE);
                } else {
                    isSearch = false;
                    history_linear.setVisibility(View.GONE);
                    tv_cancel.setVisibility(View.GONE);
                    img_delete.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void sendStr(String type, String str) {
        if ("CategoryFragment".equals(type)) {
            if (str!=null&&str.length()>20) {
                Gson gson = GsonUtils.getGson();
                mainBean = gson.fromJson(str, CategoryMainBean.class);
                if (mainBean != null && mainBean.getArticles().size() != 0) {
                    autoScorllViewInit();
                    userPagerInit();
                    categoryPagerInit();
                    imagetextListInit();
                    entityGridInit();
                    imagetextList.setFocusable(false);
                    entityGrid.setFocusable(false);
                    scrollView.smoothScrollTo(0, 0);
                }
            } else {
                Toast.makeText(getActivity(), "当前没有网络，请链接网络后在加载", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void entityGridInit() {
        List<CategoryMainBean.EntitiesBean> bean = mainBean.getEntities();
        CategoryEntityAdapter adapter = new CategoryEntityAdapter(bean, getActivity());
        entityGrid.setAdapter(adapter);
        entityGrid.setListViewHeightBasedOnChildren(entityGrid, 2);

    }

    private void imagetextListInit() {
        List<CategoryMainBean.ArticlesBean> bean = mainBean.getArticles();
        CategoryImageTextAdapter adapter = new CategoryImageTextAdapter(bean, getActivity());
        imagetextList.setAdapter(adapter);
        imagetextList.setListViewHeightBasedOnChildren(imagetextList);

    }

    private void categoryPagerInit() {
        final List<CategoryMainBean.CategoriesBean> bean = mainBean.getCategories();
        CategoryViewHolder viewHolder;
        for (int i = 0; i < bean.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.category_category_item, null);
            viewHolder = new CategoryViewHolder(view);
            String[] title = bean.get(i).getCategory().getTitle().split(" ");
            viewHolder.tv_title1.setText(title[0]);
            viewHolder.tv_title2.setText(title[1]);

            final int pos = i;
            viewHolder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = bean.get(pos).getCategory().getId();
                    String title = bean.get(pos).getCategory().getTitle();
                    Intent intent = new Intent(getActivity(), CategoryActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("title", title);
                    startActivity(intent);
                }
            });
            Picasso.with(getActivity()).load(bean.get(i).getCategory().getCover_url()).into(viewHolder.img);
            categoryPager.addView(view);
        }
    }

    class CategoryViewHolder {
        @BindView(R.id.category_category_item_title1)
        TextView tv_title1;
        @BindView(R.id.category_category_item_title2)
        TextView tv_title2;
        @BindView(R.id.category_category_item_img)
        ImageView img;

        public CategoryViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }

    private void userPagerInit() {
        List<CategoryMainBean.AuthorizeduserBean> bean = mainBean.getAuthorizeduser();
        ViewHolder viewHolder;
        for (int i = 0; i < bean.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.category_user_item, null);
            viewHolder = new ViewHolder(view);
            final CategoryMainBean.AuthorizeduserBean.UserBean authorizeduserBean = bean.get(i).getUser();
            viewHolder.tv_title.setText(authorizeduserBean.getNick());
            Picasso.with(getActivity()).load(authorizeduserBean.getAvatar_small()).into(viewHolder.img);
            viewHolder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), UserBaseActivity.class);
                    Account.UserBean userBean = new Account.UserBean();
                    userBean.setAuthorized_author(true);
                    userBean.setAvatar_large(authorizeduserBean.getAvatar_large());
                    userBean.setAvatar_small(authorizeduserBean.getAvatar_small());
                    userBean.setFollowing_count(authorizeduserBean.getFollowing_count());
                    userBean.setEntity_note_count(authorizeduserBean.getEntity_note_count());
                    userBean.setLike_count(authorizeduserBean.getLike_count());
                    userBean.setRelation(authorizeduserBean.getRelation());
                    userBean.setDig_count(authorizeduserBean.getDig_count());
                    userBean.setUser_id(authorizeduserBean.getUser_id());
                    userBean.setFan_count(authorizeduserBean.getFan_count());
                    userBean.setNick(authorizeduserBean.getNick());
                    userBean.setLocation(authorizeduserBean.getLocation());
                    userBean.setEmail(authorizeduserBean.getEmail());
                    userBean.setWebsite(authorizeduserBean.getWebsite());
                    userBean.setBio(authorizeduserBean.getBio());
                    userBean.setNickname(authorizeduserBean.getNickname());
                    userBean.setTag_count(authorizeduserBean.getTag_count());
                    userBean.setGender(authorizeduserBean.getGender());
                    userBean.setMail_verified(true);
                    intent.putExtra("data", userBean);
                    startActivity(intent);
                }
            });
            userPager.addView(view);
        }
    }

    class ViewHolder {
        @BindView(R.id.category_user_item_img)
        ImageView img;
        @BindView(R.id.category_user_item_text)
        TextView tv_title;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }

    private void autoScorllViewInit() {
        final List<CategoryMainBean.BannerBean> bean = mainBean.getBanner();
        List<View> adList = new ArrayList<>();
        Context context = getActivity();
        for (int i = 0; i < mainBean.getBanner().size(); i++) {
            LinearLayout view = new LinearLayout(context);
            ImageView img = new ImageView(context);
            view.addView(img);
            view.setBackgroundColor(Color.TRANSPARENT);
            Picasso.with(getActivity())
                    .load(bean.get(i).getImg())
                    .resize(986, 453)
                    .centerCrop()
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .into(img);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            params.setMargins(15, 5, 15, 15);
            final int pos = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String path = bean.get(pos).getUrl();
                    Intent intent = new Intent(getActivity(), WebActivity.class);
                    intent.putExtra("data",path);
                    getActivity().startActivity(intent);
                }
            });
            img.setLayoutParams(params);
            adList.add(view);


        }
        CategoryADAdapter adAdapter = new CategoryADAdapter(adList);
        autoScrollViewPager.setBackgroundColor(Color.TRANSPARENT);
        autoScrollViewPager.setAdapter(adAdapter);
        //开启自动轮播效果
        autoScrollViewPager.startAutoScroll();
        //设置边界切换的动画
        autoScrollViewPager.setBorderAnimation(false);
        //设置循环轮播
        autoScrollViewPager.setCycle(true);
        //两个页面之间切换间隔的时间
        autoScrollViewPager.setInterval(7000);
        //设置切换的方向
        autoScrollViewPager.setDirection(AutoScrollViewPager.RIGHT);
        //当手触摸的时候停止滚动
        autoScrollViewPager.setStopScrollWhenTouch(true);
    }

    @Override
    public void sendStrbefore(String type) {

    }

    @Override
    public void sendStrAfter(String type) {

    }

    @OnClick(R.id.category_user_recommend)
    protected void recommendUser() {

    }
}
