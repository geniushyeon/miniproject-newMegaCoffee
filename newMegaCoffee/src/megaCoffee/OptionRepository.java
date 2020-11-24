package megaCoffee;

import megaCoffee.entities.Option;

import java.util.ArrayList;
import java.util.List;

public class OptionRepository {
    List<Option> optionList = new ArrayList<>();

    public OptionRepository() {
        setOptions();
    }

    private void setOptions() {
        optionList.add(new Option("샷추가", 500));
    }
}
