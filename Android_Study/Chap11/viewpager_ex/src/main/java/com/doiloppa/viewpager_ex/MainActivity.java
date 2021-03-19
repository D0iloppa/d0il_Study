package com.doiloppa.viewpager_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    String[] names = {"트와이스","여자친구","레드벨벳","아이유"};
    int[] ids = {R.drawable.twice,R.drawable.girl,R.drawable.red,R.drawable.iu};
    String[] callNums = {"010-1234-5678","010-1275-4564","010-4786-3124","010-3000-4000"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter); // 어댑터 연결

        // 공백인 페이지(오류로 인한)를 띄우지 않기위해 페이지 수 제한
        viewPager.setOffscreenPageLimit(names.length);



    }

    class ViewPagerAdapter extends PagerAdapter{

        Context context;

        public ViewPagerAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() { // 1 . 페이저어뎁터에서 관리할 페이지의 수
            return names.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            // 3. instantiateItem 메소드에 생성된 객체가 뷰페이지와 맞는지 확인하는 메소드
            return view.equals(object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            // 2. viewPager에서 사용할 뷰 객체를 생성 및 등록
            // position은 안의 페이지의 인덱스 번호라 생각하면 된다.
            // 내부적으로 count갯수만큼 돌고 각각의 인덱스 번호가 들어간다.
            Person person = new Person(context);

            person.setName(names[position]);
            person.setImage(ids[position]);
            person.setCall_Btn(callNums[position]);

            // 각각의 객체들을 만들고 컨테이너에 넣는다.
            // 컨테이너는 이들을 담는 방이라고 생각하자
            container.addView(person);

            return person;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            // 4. 화면에 보이지 않는 view 객체를 삭제해서 관리
            // 그렇지 않으면 페이지의 갯수가 많을 때 메모리 낭비가 생긴다.

            container.removeView((View) object);
//            super.destroyItem(container, position, object);
        }
    }







}