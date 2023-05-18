package sv.edu.usam.crudapp.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Provedores extends BaseHelper {
    Context context;
    public Provedores(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertProvedor(String NOMPROV,String TELPROV,String CORPROV){
        long codigo=0;
        try {
            BaseHelper baseHelper = new BaseHelper(context);
            SQLiteDatabase db = baseHelper.getWritableDatabase();

            ContentValues valoresProv = new ContentValues();

            valoresProv.put("NOMPROV", NOMPROV);
            valoresProv.put("TELPROV", TELPROV);
            valoresProv.put("CORPROV", CORPROV);

             codigo = db.insert(NOMBRE_TABLAPR, null, valoresProv);
            return codigo;
        }catch (Exception ex){
            ex.toString();
            return codigo=0;
        }
    }
}
