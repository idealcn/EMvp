package com.xuan.eapi.factory.presenter;

import android.content.Context;

import com.xuan.eapi.BasePresenter;
import com.xuan.eapi.factory.component.ReflectCreate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author : xuan.
 * Date : 2018/6/1.
 * Description :自动创建Presenter
 */

public class ReflectPresenterFactory implements ReflectCreate<BasePresenter>{
    private Context mContext;

    public ReflectPresenterFactory(Context context) {
        this.mContext = context;
    }

    @Override
    public BasePresenter reflectCreate(Class<?> clazz) {
        BasePresenter presenter = null;
        try {
            Constructor c = clazz.getConstructor(Context.class);
            presenter = (BasePresenter) c.newInstance(mContext);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return presenter;
    }
}
