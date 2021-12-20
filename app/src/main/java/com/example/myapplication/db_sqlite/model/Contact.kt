package com.example.myapplication.db_sqlite.model

class Contact (val name: String, val phone: String) {
    override fun toString(): String {
        return "Nome: $name / Telefone: $phone"
    }
}