/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas.util;

/**
 *
 * @author Daniel
 */
public interface IEntityModel {
    
    public Object get(String name);
    public void set(String name, Object value);
    
}
