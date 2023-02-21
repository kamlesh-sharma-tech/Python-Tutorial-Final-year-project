package com.android.pythontutorial.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.pythontutorial.R;
import com.android.pythontutorial.databinding.ActivityProgramsBinding;

public class ProgramsActivity extends AppCompatActivity {
    CardView p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30;
    private Object Menu;
    ActivityProgramsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProgramsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        getSupportActionBar().setTitle("Python Programs");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        p1=(CardView) findViewById(R.id.p1);
        p2=(CardView) findViewById(R.id.p2);
        p3=(CardView) findViewById(R.id.p3);
        p4=(CardView) findViewById(R.id.p4);
        p5=(CardView) findViewById(R.id.p5);
        p6=(CardView) findViewById(R.id.p6);
        p7=(CardView) findViewById(R.id.p7);
        p8=(CardView) findViewById(R.id.p8);
        p9=(CardView) findViewById(R.id.p9);
        p10=(CardView) findViewById(R.id.p10);
        p11=(CardView) findViewById(R.id.p11);
        p12=(CardView) findViewById(R.id.p12);
        p13=(CardView) findViewById(R.id.p13);
        p14=(CardView) findViewById(R.id.p14);
        p15=(CardView) findViewById(R.id.p15);
        p16=(CardView) findViewById(R.id.p16);
        p17=(CardView) findViewById(R.id.p17);
        p18=(CardView) findViewById(R.id.p18);
        p19=(CardView) findViewById(R.id.p19);
        p20=(CardView) findViewById(R.id.p20);
        p21=(CardView) findViewById(R.id.p21);
        p22=(CardView) findViewById(R.id.p22);
        p23=(CardView) findViewById(R.id.p23);
        p24=(CardView) findViewById(R.id.p24);
        p25=(CardView) findViewById(R.id.p25);
        p26=(CardView) findViewById(R.id.p26);
        p27=(CardView) findViewById(R.id.p27);
        p28=(CardView) findViewById(R.id.p28);
        p29=(CardView) findViewById(R.id.p29);
        p30=(CardView) findViewById(R.id.p30);

        binding.p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program1Activity.class);
                startActivity(intent);
            }
        });

        binding.p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program2Activity.class);
                startActivity(intent);
            }
        });

        binding.p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program3Activity.class);
                startActivity(intent);
            }
        });

        binding.p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program4Activity.class);
                startActivity(intent);
            }
        });

        binding.p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program5Activity.class);
                startActivity(intent);
            }
        });

        binding.p6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program6Activity.class);
                startActivity(intent);
            }
        });

        binding.p7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program7Activity.class);
                startActivity(intent);
            }
        });

        binding.p8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program8Activity.class);
                startActivity(intent);
            }
        });

        binding.p9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program9Activity.class);
                startActivity(intent);
            }
        });

        binding.p10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program10Activity.class);
                startActivity(intent);
            }
        });

        binding.p11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program11Activity.class);
                startActivity(intent);
            }
        });

        binding.p12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program12Activity.class);
                startActivity(intent);
            }
        });

        binding.p13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program13Activity.class);
                startActivity(intent);
            }
        });

        binding.p14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program14Activity.class);
                startActivity(intent);
            }
        });

        binding.p15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program15Activity.class);
                startActivity(intent);
            }
        });

        binding.p16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program16Activity.class);
                startActivity(intent);
            }
        });

        binding.p17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program17Activity.class);
                startActivity(intent);
            }
        });

        p18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program18Activity.class);
                startActivity(intent);
            }
        });

        p19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program19Activity.class);
                startActivity(intent);
            }
        });

        p20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program20Activity.class);
                startActivity(intent);
            }
        });
        p21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program21Activity.class);
                startActivity(intent);
            }
        });
        p22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program22Activity.class);
                startActivity(intent);
            }
        });
        p23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program23Activity.class);
                startActivity(intent);
            }
        });
        p24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program24Activity.class);
                startActivity(intent);
            }
        });
        p25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program25Activity.class);
                startActivity(intent);
            }
        });
        p26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program26Activity.class);
                startActivity(intent);
            }
        });
        p27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program27Activity.class);
                startActivity(intent);
            }
        });
        p28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program28Activity.class);
                startActivity(intent);
            }
        });
        p29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program29Activity.class);
                startActivity(intent);
            }
        });
        p30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramsActivity.this, Program30Activity.class);
                startActivity(intent);
            }
        });
    }

}