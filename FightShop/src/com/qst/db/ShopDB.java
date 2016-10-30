package com.qst.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ShopDB extends SQLiteOpenHelper {

    public static final String PRODUCT_TABLE = "product_tb";//商品表
    public static final String PRODUCTCATEGORY_TABLE = "productCategory_tb";//商品类别表
    public static final String PROVIDER_TABLE = "provider_tb";//供应商表

    public static final String SALERECORD_TABLE = "saleRecord_tb";//出售记录表
    public static final String DETAIL_TABLE = "detail_tb";//出售记录详情表

    public static final String STORE_TABLE = "store_tb";//进货表
    public static final String STOREPRIVDER_TABLE = "storePrivder_tb";//进货供应商表
    public static final String STOREDETAIL_TABLE = "storeDetail_tb";//进货明细表



    public ShopDB(Context context) {
        super(context, "ShopDB.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    	Log.i("ShopDB","DBonCreate");
    	 db.execSQL("create table if not exists "+PRODUCT_TABLE+"(ProductId integer primary key autoincrement, " +
                 "ProductName text not null, " +
                 "ProductCost real not null, " +
                 "ProductPrice real not null, " +
                 "ProviderId integer not null, " +
                 "ProductNum integer not null, " +
                 "ProductCategoryId integer not null, " +
                 "ScanCode text not null, " +
                 "Other text, "+
                 "FOREIGN KEY (ProductCategoryId ) REFERENCES "+PRODUCTCATEGORY_TABLE+"(ProductCategoryId), " +
                 "FOREIGN KEY (ProviderId ) REFERENCES "+PROVIDER_TABLE+"(ProviderId))");
         db.execSQL("create table if not exists "+
                 PRODUCTCATEGORY_TABLE+
                 "(ProductCategoryId integer primary key, " +
                 "ProductCategoryName text not null, " +
                 "Other text)");
         db.execSQL("create table if not exists "+PROVIDER_TABLE+"(ProviderId integer primary key autoincrement, " +
                 "ProviderName text not null, " +
                 "ProviderPlace text, " +
                 "ProviderPhone1 text, " +
                 "ProviderPhone2 text, " +
                 "Other text)");

         db.execSQL("create table if not exists "+SALERECORD_TABLE+"(SaleRecordId integer primary key autoincrement, " +
                 "SaleRecordPeople text, " +
                 "SaleRecordDate text not null, " +
                 "Customer text, " +
                 "AllPrice real not null, " +
                 "AllNum integer not null, " +
                 "Profit real not null, " +
                 "Other text)");
         db.execSQL("create table if not exists "+DETAIL_TABLE+"(DetailId integer primary key not null, " +
                 "SaleRecordId integer not null, " +
                 "ScanCode text not null, " +
                 "ProductCost real not null, " +
                 "ProductPrice real not null, " +
                 "Num integer not null, " +
                 "Other text, "+
                 "FOREIGN KEY (SaleRecordId ) REFERENCES "+SALERECORD_TABLE+"(SaleRecordId))");

         db.execSQL("create table if not exists "+STORE_TABLE+"(StoreId integer primary key autoincrement, " +
                 "StoreName text not null, " +
                 "StoreDate text not null, " +
                 "StoreAllPrice real not null, " +
                 "StoreAllNum integer not null, " +
                 "Other text)");
         db.execSQL("create table if not exists "+STOREPRIVDER_TABLE+"(StoreProviderId integer primary key not null, " +
                 "StoreId integer not null, " +
                 "ProviderId integer not null, " +
                 "ProviderAllPrice real not null, " +
                 "ProviderAllNum integer not null, " +
                 "Other text, "+
                 "FOREIGN KEY (StoreId) REFERENCES "+STORE_TABLE+"(StoreId))");
         db.execSQL("create table if not exists "+STOREDETAIL_TABLE+"(StoreDetailId integer primary key not null, " +
                 "StoreId integer not null, " +
                 "StoreProviderId integer not null, " +
                 "ScanCode text not null, " +
                 "ProductCost real not null, " +
                 "StoreAllNum integer not null, "+
                 "FOREIGN KEY (StoreId) REFERENCES "+STORE_TABLE+"(StoreId), " +
                 "FOREIGN KEY (StoreProviderId) REFERENCES "+STOREPRIVDER_TABLE+"(StorePrivderId))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
