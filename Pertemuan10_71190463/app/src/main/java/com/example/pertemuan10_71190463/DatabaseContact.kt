package com.example.pertemuan10_71190463

import android.provider.BaseColumns

class DatabaseContact {
    object Penduduk: BaseColumns {
        const val TABLE_NAME = "penduduk"
        const val COLUMN_NAME_NAMA = "nama"
        const val COLUMN_NAME_PEKERJAAN = "pekerjaan"
        const val COLUMN_NAME_UMUR = "umur"

        const val SQL_CREATE_TABLE = "Create Table ${TABLE_NAME}(" +
                " ${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                " ${COLUMN_NAME_NAMA} TEXT," +
                " ${COLUMN_NAME_PEKERJAAN} TEXT," +
                " ${COLUMN_NAME_UMUR} INTEGER" +
                ")"

        const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS ${TABLE_NAME}"
    }
}