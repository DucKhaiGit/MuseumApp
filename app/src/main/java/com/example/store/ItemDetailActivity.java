package com.example.store;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ItemDetailActivity extends AppCompatActivity {

    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        btnBack = findViewById(R.id.btnBack);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null)
        {
            return;
        }
        Item item = (Item) bundle.get("object_item");
        TextView tv_itemdetail = findViewById(R.id.tv_detail);
        if ("Bát cổ chạm khắc đầu rồng".equals(item.getName()))
        {
            tv_itemdetail.setText("Bát cổ chạm khắc đầu rồng là một trong những cổ vật quý giá và mang đậm nét văn hóa lịch sử của Việt Nam. Được chế tác từ thời phong kiến, chiếc bát này thường được làm từ sứ cao cấp hoặc đồng, với các chi tiết chạm khắc tinh xảo. Hình ảnh đầu rồng được khắc nổi bật trên bát, biểu tượng cho quyền lực, sự may mắn và thịnh vượng trong văn hóa Á Đông. Bát cổ này không chỉ là một tác phẩm nghệ thuật mà còn là một minh chứng sống động cho kỹ thuật chế tác thủ công tài hoa của các nghệ nhân xưa. Ngày nay, bát cổ chạm khắc đầu rồng thường được trưng bày trong các viện bảo tàng hoặc các bộ sưu tập tư nhân, thể hiện giá trị văn hóa và lịch sử to lớn mà nó mang lại.");
        }
        if ("Độc cô cửu kiếm".equals(item.getName()))
        {
            tv_itemdetail.setText("Độc Cô Cửu Kiếm là một cổ vật quý hiếm, đại diện cho nghệ thuật chế tác kiếm đỉnh cao của thời phong kiến Việt Nam. Kiếm được làm từ thép chất lượng cao, với lưỡi sắc bén và họa tiết chạm khắc tinh xảo trên thân. Độc Cô Cửu Kiếm không chỉ là vũ khí, mà còn là biểu tượng của sức mạnh và lòng kiên trung. Theo truyền thuyết, kiếm này từng thuộc về một vị tướng anh dũng, và mỗi vết chạm khắc trên kiếm kể lại một chiến công lẫy lừng. Ngày nay, Độc Cô Cửu Kiếm thường được trưng bày trong các bảo tàng lịch sử, thể hiện giá trị nghệ thuật và lịch sử to lớn.");        }
        if ("Hóa thạch khủng long".equals(item.getName()))
        {
            tv_itemdetail.setText("Hóa thạch khủng long là một cổ vật khoa học quý báu, giúp chúng ta hiểu rõ hơn về thời kỳ cổ đại và sự phát triển của sự sống trên Trái Đất. Những mảnh xương hóa thạch này thường được tìm thấy trong các lớp đá cổ và được bảo quản rất tốt. Hóa thạch khủng long cung cấp thông tin quan trọng về kích thước, hình dạng và cách sống của các loài khủng long. Các bảo tàng tự nhiên thường trưng bày hóa thạch khủng long để giáo dục công chúng về lịch sử tiến hóa và sự đa dạng của sự sống.");        }
        if ("Mặt nạ thủ lam ngư".equals(item.getName()))
        {
            tv_itemdetail.setText("Mặt nạ thủ lam ngư là một cổ vật nghệ thuật độc đáo, thường được làm từ gỗ và sơn màu tinh xảo. Mặt nạ này thể hiện hình ảnh của một loài cá huyền thoại trong văn hóa dân gian, được cho là mang lại sự may mắn và bảo vệ khỏi tà ma. Mặt nạ thủ lam ngư thường được sử dụng trong các lễ hội truyền thống và nghi lễ tôn giáo. Ngày nay, mặt nạ này được coi là một tác phẩm nghệ thuật quý giá, thể hiện sự sáng tạo và tài năng của các nghệ nhân xưa.");        }
        if ("Trống đồng".equals(item.getName()))
        {
            tv_itemdetail.setText("Trống đồng là một cổ vật tiêu biểu của nền văn minh Đông Sơn, được chế tác từ đồng thau với kỹ thuật đúc khuôn tinh vi. Trống đồng thường có hoa văn phức tạp và hình ảnh động vật, con người, và các cảnh sinh hoạt. Trống không chỉ là nhạc cụ, mà còn là biểu tượng quyền lực và sự giàu có của các thủ lĩnh bộ tộc. Ngày nay, trống đồng được trưng bày trong các bảo tàng lịch sử và văn hóa, thể hiện giá trị nghệ thuật và lịch sử lâu đời của nền văn minh Việt Nam.");        }
        if ("Tượng thần".equals(item.getName()))
        {
            tv_itemdetail.setText("Tượng voi thần là một cổ vật tôn giáo, thường được chế tác từ đá hoặc kim loại, với hình ảnh voi được khắc họa một cách trang nghiêm và uy nghi. Voi thần trong nhiều văn hóa Á Đông được xem là biểu tượng của sự thông thái, sức mạnh và may mắn. Tượng voi thần thường được đặt trong các đền thờ và chùa chiền, nơi người dân đến cầu nguyện và xin phước lành. Ngày nay, tượng voi thần được coi là một tác phẩm nghệ thuật tôn giáo quý giá, thể hiện sự sùng bái và tín ngưỡng sâu sắc của con người.");
        }


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



    }
}