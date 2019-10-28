package pages;

import com.google.common.collect.ImmutableMap;

public class PosterList extends BasePage {
    private ImmutableMap<Object, Object> posterListSelectors = ImmutableMap.builder()
            .put("POSTER_LIST", ".mob_fix_container")
            .put("MOVE_TO_RIGHT", ".mp_toright")
            .put("MOVE_TO_LEFT", ".mp_toleft")
            .build();
}
