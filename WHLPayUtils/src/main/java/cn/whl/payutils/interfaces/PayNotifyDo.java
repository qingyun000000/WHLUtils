/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whl.payutils.interfaces;

/**
 *
 * @author Administrator
 * @param <T>
 */
public interface PayNotifyDo<T extends PayNotifyDoParams> {
    
    public Object payNotifyDo(T t);
}
