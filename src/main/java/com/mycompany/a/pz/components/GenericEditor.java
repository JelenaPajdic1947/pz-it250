/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.components;

import com.mycompany.a.pz.dao.GenericDao;
import com.mycompany.a.pz.entities.AbstractEntity;
import java.util.List;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.PropertyConduit;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.BeanModelSource;
import org.apache.tapestry5.services.PropertyConduitSource;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

/**
 *
 * @author pc
 * @param <T>
 */

public class GenericEditor<T extends AbstractEntity> {

    @Inject
    private PropertyConduitSource conduit;
    @Inject
    private GenericDao genericDao;
    @Property
    @Persist
    private T bean;
    @Property
    private T row;
    @Inject
    private BeanModelSource beanModelSource;
    @Inject
    private ComponentResources componentResources;

    private Class klasa;

    {
        PropertyConduit conduit1 = conduit.create(getClass(), "bean");
        klasa = conduit1.getPropertyType();
    }

    public List<T> getGrid() {
        List<T> temp = genericDao.loadAllActive(klasa);
        return temp;
    }

    public BeanModel<T> getFormModel() {
        return beanModelSource.createEditModel(klasa,
                componentResources.getMessages()).exclude("id");
    }

    public BeanModel<T> getGridModel() {
        return beanModelSource.createDisplayModel(klasa,
                componentResources.getMessages()).exclude("id");
    }

    @CommitAfter
    Object onActionFromBrisanje(int id) {
        genericDao.delete(id, klasa);
        return this;
    }

    @CommitAfter
    Object onActionFromEdit(int row) {
        bean = (T) genericDao.getElementById(row, klasa);
        return this;
    }

    @CommitAfter
    public Object onSuccess() {
        genericDao.merge(bean);
        try {
            bean = (T) klasa.newInstance();
        } catch (Exception ex) {
        }
        return this;
    }


}
