package br.com.cabal.findswitch.graficos;
import java.util.List;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public abstract class AbstractVaadinChart extends VerticalLayout implements Sample {

    private final VerticalLayout content;

    public AbstractVaadinChart() {
        content = this;
        content.setSizeFull();
    }

    protected void setup() {
        Component map = getChart();
        content.addComponent(map);
        content.setExpandRatio(map, 1);
    }

    protected abstract Component getChart();

    @Override
    public void attach() {
        super.attach();
        setup();
    }
   
    @Override
    public Component getWrappedComponent() {
        setup();
        return content;
    }

    @Override
    public Component getComponentUsedByPropertyEditor() {
        // TODO Auto-generated method stub
        return null;
    }
   
    @Override
    public List getPropertyEditorExcludedList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List getExtraComponentsForPropertyEditor() {
        return null;
    };

    private Item sampleItem;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Item getSampleItem() {
        if (sampleItem == null) {
            sampleItem = new BeanItem(getComponentUsedByPropertyEditor());
        }
        return sampleItem;
    }
   
    @Override
    public void sampleOpened() {
        // TODO Auto-generated method stub
       
    }


}