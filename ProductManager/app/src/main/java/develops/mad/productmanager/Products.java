package develops.mad.productmanager;

import android.support.annotation.NonNull;

public class Products {
    private int _id;
    private String _name;
    private double _price;
    private String _dateMfg;

    public Products() {
    }

    public Products(String dateMfg, int id, String name, double price) {
        this._dateMfg = dateMfg;
        this._id = id;
        this._name = name;
        this._price = price;
    }

    public String get_dateMfg() {
        return _dateMfg;
    }

    public void set_dateMfg(String _dateMfg) {
        this._dateMfg = _dateMfg;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public double get_price() {
        return _price;
    }

    public void set_price(double _price) {
        this._price = _price;
    }

    @NonNull
    @Override
    public String toString() {

        if(_name.equalsIgnoreCase("No Product Selected"))
            return "---- No Product Selected ----";
        else
            return _name +" || "+_price+" || "+_dateMfg;
    }
}
