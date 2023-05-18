package sv.edu.usam.crudapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import sv.edu.usam.crudapp.datos.BaseHelper;

public class MainActivity extends AppCompatActivity {

    DrawerLayout dwrLayout;
    Toolbar tlBarra;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlBarra=findViewById(R.id.toolbar);
        dwrLayout=findViewById(R.id.drawerLayout);
        navView=findViewById(R.id.navigator);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,dwrLayout,tlBarra,R.string.open,R.string.close);
        dwrLayout.addDrawerListener(toggle);
        toggle.syncState();
            toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white,null));

        BaseHelper baseHelper=new BaseHelper(this);

        SQLiteDatabase db =baseHelper.getWritableDatabase();
        if(db!=null){
            Toast.makeText(this, "Base de datos creada", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Error en crear la DB", Toast.LENGTH_SHORT).show();
        }
            navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()){
                        case R.id.mensajes1:
                            dwrLayout.closeDrawer(GravityCompat.START);
                            Toast.makeText(getApplicationContext(), "Mensaje", Toast.LENGTH_SHORT).show();
                            fragmentosR(new MensajesFragment());
                            break;
                        case R.id.comentarios:
                            dwrLayout.closeDrawer(GravityCompat.START);
                            fragmentosR(new CommentariosFragment());
                            Toast.makeText(getApplicationContext(), "Comentarios", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.enviar:
                            dwrLayout.closeDrawer(GravityCompat.START);
                            fragmentosR(new EnviarFragment());

                            Toast.makeText(getApplicationContext(), "Enviar", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.compartir:
                            dwrLayout.closeDrawer(GravityCompat.START);
                            fragmentosR(new CompartirFragment());
                            Toast.makeText(getApplicationContext(), "Compartir", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.brujula:
                            dwrLayout.closeDrawer(GravityCompat.START);
                            fragmentosR(new ExplorarFragment());
                            Toast.makeText(getApplicationContext(), "Explorar", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    return false;
                }
            });
    }
    private void fragmentosR(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmlayoutContent,fragment);
        fragmentTransaction.commit();
    }
}