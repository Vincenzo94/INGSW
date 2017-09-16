/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Observable;

/**
 *
 * @author Andrea
 */
public abstract class Document extends Observable{
    public abstract String getState();
    public abstract Integer getGeneratedDate();
    public abstract Integer getInsertedDate();
    public abstract Integer getIussedDate();
    public abstract Integer getPaymentDate();
}
