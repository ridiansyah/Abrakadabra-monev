package com.wahyuridiansyah.abrakadabra.materi;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2Fragment;
import com.wahyuridiansyah.abrakadabra.R;
import com.wahyuridiansyah.abrakadabra.activity.MainActivity;


public class belajar_medhayoh extends AppIntro {
    Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().hide();
        addSlide(AppIntro2Fragment.newInstance("MERADHAYOH/MEDHAYOH","Apa wae sing perlu digatekake yen maradhayoh/medhayoh?",
                R.drawable.medhayoh1, Color.parseColor("#ff6f00")));

        addSlide(AppIntro2Fragment.newInstance("ANGON WAYAH, NGERTI WEKTU","Maradhayoh ora kena sakarepe dhewe, kudu ngerti wayah sing trep kanggo mertamu. Aja mertamu wayahe wong ngaso lan turu, kira-kira jam loro nganti jam papat sore. Aja mertamu wancine wong mangan. Rembugan aja nglantur. Sing bisa momong pangrasane sing duwe omah. Yen sajake ora seneng dijak ngrembug sawenehing bab, becike aja diterusake.",
                R.drawable.medhayoh2, Color.parseColor("#ff80ab")));

        addSlide(AppIntro2Fragment.newInstance("TRAPSILA","Menawa diajak mangan ing ruang makan anggone imbuh ngenteni dimanggakake lan njupuk sacukupe wae. Rampung dhahar sendhok lan garbu dikurepake ing piring lan dhaharan ing piring kudu gusis kajaba balung lan eri. Aja watuk sajrone dhahar lan aja glegeken sawise rampung. Menawa kudu watuk utawa glegeken diempet dhisik nganti ninggalake ruang makan",
                R.drawable.medhayoh3, Color.parseColor("#006064")));//

        addSlide(AppIntro2Fragment.newInstance("AJA PADU","Yen ana wong maradhayoh sing perlune nagih utang, nagih janji, utawa marani barang sing disilih. Sok-sok sing duwe omah gawe anyel, upamane durung bisa nyaur utange, ora netepi janjine lan barang sing disilih rusak. Nanging senajan nesu dikaya ngapa becike diampah sabisane. Sebab kurang prayoga yen nesu lan muna-muni ing omahe liyan. Apa maneh yen keprungu tangga teparo nganti padha metu nonton. Sulayane janji bisa dirembug sing sareh amrih kekarone padha mareme. Senajan lagi nesu nanging yen mulih tetep pamitan sing apik.",
                R.drawable.medhayoh4, Color.parseColor("#afb42b")));//


        //showStatusBar(false);
        setBarColor(Color.parseColor("#333639"));
        setSeparatorColor(Color.parseColor("#2196f3"));
    }

    //ini hasil dari keyboard baru cuy

    @Override
    public void onDonePressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onSlideChanged() {
    }


}
