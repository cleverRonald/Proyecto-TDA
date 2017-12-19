package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dlanor on 17/12/2017.
 */


public class DBhelper extends SQLiteOpenHelper {
    public DBhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table usuarios(_ID integer primary key autoincrement, DniUsu text,NombreUsu text , ApellidoUsu text, UsuarioUsu text, PasswordUsu text,DiaNaci text, MesNaci text,AnioNaci text, NombreTa text, DiaTa text, MesTa text, AnioTa text, InformacionTa text, NombreCum text ,DiaCum text,MesCum text,AnioCum text, InformacionCum text);";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }

    public void abrir() {
        this.getWritableDatabase();
    }

    public void cerrar() {
        this.close();
    }

    public void insertarReg(String dniUsu,String nomUsu, String apeUsu, String usuUsu, String passUsu, String diana, String mesnac, String anionac) {
        ContentValues valores = new ContentValues();
        valores.put("DniUsu", dniUsu);
        valores.put("NombreUsu", nomUsu);
        valores.put("ApellidoUsu", apeUsu);
        valores.put("UsuarioUsu", usuUsu);
        valores.put("PasswordUsu", passUsu);
        valores.put("DiaNaci",diana);
        valores.put("MesNaci",mesnac);
        valores.put("AnioNaci",anionac);
        this.getWritableDatabase().insert("usuarios", null, valores);
    }
    public  void insertarTarea(String nomTa,String dTa,String mTa,String aTA,String infor){
        ContentValues valores=new ContentValues();
        valores.put("NombreTa",nomTa);
        valores.put("Dia",dTa);
        valores.put("MesTa",mTa);
        valores.put("AnioTa",aTA);
        valores.put("InformacionTa",infor);
        this.getWritableDatabase().insert("usuarios",null,valores);
    }
    public void insertarecord(String nomcu, String diacu,String mescu,String aniocu,String inforcu){
        ContentValues valores=new ContentValues();
        valores.put("NombreCum",nomcu);
        valores.put("DiaCum",diacu);
        valores.put("MesCum",mescu);
        valores.put("AnioCum",aniocu);
        valores.put("InformacionCum",inforcu);
        this.getWritableDatabase().insert("usuarios",null,valores);
    }

    public Cursor ConsultorUsuPass(String dni,String usuUsu, String passUsu) throws SQLException {
        Cursor mcursor = null;

        mcursor = this.getReadableDatabase().query("usuarios", new String[]{"_ID","DniUsu", "NombreUsu", "ApellidoUsu", "UsuarioUsu", "PasswordUsu","DiaNaci" ," MesNaci" ,"AnioNaci "," NombreTa" , "DiaTa ", "MesTa" , "AnioTa" , "InformacionTa" , "NombreCum"  ,"DiaCum ","MesCum ","AnioCum ", "InformacionCum" },"DniUsu like '"+dni+"'and UsuarioUsu like '" + usuUsu + "' and PasswordUsu like '" + passUsu + "'", null, null, null, null);


        return mcursor;
    }
}