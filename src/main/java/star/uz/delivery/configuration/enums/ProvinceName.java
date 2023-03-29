package star.uz.delivery.configuration.enums;

public enum ProvinceName {
    TASHKENT("Toshkent shahri"),
    ANDIJAN("Andijon viloyati"),
    BUKHARA("Buxoro viloyati"),
    FERGANA("Farg'ona viloyati"),
    NAMANGAN("Namangan viloyati"),
    NAVOIY("Navoiy viloyati"),
    TOSHKENT("Toshkent viloyati"),
    SIRDARYO("Sirdaryo viloyati"),
    SAMARKAND("Samarqand viloyati"),
    SURXONDARY("Surxondaryo viloyati"),
    QASHQADARYO("Qashqadaryo viloyati"),
    XORAZM("Xorazm viloyati"),
    JIZZAX("Jizzax viloyati"),
    QORAQALPOQ("Qoraqalpog'iston Respublikasi");
    private final String name;
    ProvinceName(String name){
         this.name=name;
    }
    public String getName(){
        return name;
    }
}
