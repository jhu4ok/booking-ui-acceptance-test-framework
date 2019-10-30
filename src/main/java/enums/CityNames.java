package enums;

public enum CityNames {
    KYIV("Київ"),
    DNIPRO("Дніпро"),
    LVIV("Львів"),
    ODESA("Одеса"),
    ZAPORIZHZHIA("Запоріжжя"),
    MUKOLAIV("Миколаїв"),
    KHERSON("Херсон"),
    KHARKIV("Харків"),
    KHMELNIYSKY("Хмельницький"),
    ZHYTOMYR("Житомир"),
    KRYVYI_RIH("Кривий Ріг"),
    MARIUPOL("Маріуполь"),
    RIVNE("Рівне"),
    CHERNIHIV("Чернігів"),
    POLTAVA("Полтава"),
    LUTSK("Луцьк"),
    CHERKASY("Черкаси");

    private final String cityName;

    CityNames(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

}
