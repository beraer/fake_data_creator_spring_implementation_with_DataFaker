package myproject.s29315tpo06.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LocalizedHeaderService {

    public Map<String, String> getLocalizedHeaders(String lang) {
        return switch (lang) {
            case "pl" -> Map.of(
                    "firstName", "Imię", "lastName", "Nazwisko", "birthDate", "Data urodzenia",
                    "address", "Adres", "university", "Uniwersytet", "country", "Kraj",
                    "phone", "Telefon", "email", "E-mail", "job", "Zawód"
            );
            case "fr" -> Map.of(
                    "firstName", "Prénom", "lastName", "Nom", "birthDate", "Date de Naissance",
                    "address", "Adresse", "university", "Université", "country", "Pays",
                    "phone", "Téléphone", "email", "Courriel", "job", "Emploi"
            );
            case "de" -> Map.of(
                    "firstName", "Vorname", "lastName", "Nachname", "birthDate", "Geburtsdatum",
                    "address", "Adresse", "university", "Universität", "country", "Land",
                    "phone", "Telefon", "email", "E-Mail", "job", "Beruf"
            );
            case "es" -> Map.of(
                    "firstName", "Nombre", "lastName", "Apellido", "birthDate", "Fecha de Nacimiento",
                    "address", "Dirección", "university", "Universidad", "country", "País",
                    "phone", "Teléfono", "email", "Correo electrónico", "job", "Trabajo"
            );
            case "it" -> Map.of(
                    "firstName", "Nome", "lastName", "Cognome", "birthDate", "Data di nascita",
                    "address", "Indirizzo", "university", "Università", "country", "Paese",
                    "phone", "Telefono", "email", "Email", "job", "Professione"
            );
            case "pt" -> Map.of(
                    "firstName", "Primeiro Nome", "lastName", "Último Nome", "birthDate", "Data de nascimento",
                    "address", "Endereço", "university", "Universidade", "country", "País",
                    "phone", "Telefone", "email", "Email", "job", "Profissão"
            );
            case "ja" -> Map.of(
                    "firstName", "名", "lastName", "姓", "birthDate", "生年月日",
                    "address", "住所", "university", "大学", "country", "国",
                    "phone", "電話番号", "email", "メール", "job", "職業"
            );
            case "zh" -> Map.of(
                    "firstName", "名字", "lastName", "姓氏", "birthDate", "出生日期",
                    "address", "地址", "university", "大学", "country", "国家",
                    "phone", "电话", "email", "电子邮件", "job", "职业"
            );
            case "ru" -> Map.of(
                    "firstName", "Имя", "lastName", "Фамилия", "birthDate", "Дата рождения",
                    "address", "Адрес", "university", "Университет", "country", "Страна",
                    "phone", "Телефон", "email", "Эл. почта", "job", "Профессия"
            );
            default -> Map.of(
                    "firstName", "First Name", "lastName", "Last Name", "birthDate", "Date of Birth",
                    "address", "Address", "university", "University", "country", "Country",
                    "phone", "Phone", "email", "Email", "job", "Job"
            );
        };
    }
}

