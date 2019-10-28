package enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static CityNames getEnum(String labelName) {
        for (CityNames name : values()) {
            if (name.getCityName().equals(labelName)) {
                return name;
            }
        }
        throw new IllegalArgumentException("No enum constant matching label name");
    }

    public static List<String> getCityNamesTree() {
        return Stream.of(CityNames.values())
                .map(CityNames::getCityName)
                .collect(Collectors.toList());
    }
}
