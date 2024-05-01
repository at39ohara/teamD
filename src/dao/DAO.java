package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

// データベースアクセスの機能
public class DAO {

    // データソース
    static DataSource ds;

    // データベースの接続を取得するメソッド
    public Connection getConnection() throws Exception {
        // データソースが未初期化の場合
        if (ds == null) {
            // InitialContextのインスタンスを生成する
            InitialContext ic = new InitialContext();
            // データソースをルックアップする
            ds = (DataSource) ic.lookup("java:/comp/env/jdbc/teamD");
        }
        // データベースの接続を返す
        return ds.getConnection();
    }
}