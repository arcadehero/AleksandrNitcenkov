package com.epam.tc.nitcenkov.hw7;

import static java.lang.String.join;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.nitcenkov.hw7.entities.MetalAndColors;
import com.epam.tc.nitcenkov.hw7.forms.MetalsAndColorsForm;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @FindBy(css = ".form")
    public static MetalsAndColorsForm metalsAndColorsForm;

    @FindBy(css = ".results > li")
    public static List<UIElement> result;

    @FindBy(id = "user-icon")
    public Icon userIcon;

    @FindBy(css = ".logout")
    public Button logOut;

    public static List<String> getActualResult() {
        return result.stream().map(UIElement::getText).collect(Collectors.toList());
    }

    public static List<String> getExpectedResult(MetalAndColors input) {
        return new ArrayList<>() {
            {
                add(String.format("Summary: %d", input.getSummary().get(0) + input.getSummary().get(1)));
                add(String.format("Elements: %s", join(", ", input.getElements())));
                add(String.format("Color: %s", input.getColor()));
                add(String.format("Metal: %s", input.getMetals()));
                add(String.format("Vegetables: %s", join(", ", input.getVegetables())));
            }
        };
    }
}
