/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Res Value Object.
  * This class is value object representing database table reserva
  * This class is intented to be used together with associated Dao object.
  */

 /**
  * This sourcecode has been generated by FREE DaoGen generator version 2.4.1.
  * The usage of generated code is restricted to OpenSource software projects
  * only. DaoGen is available in http://titaniclinux.net/daogen/
  * It has been programmed by Tuomo Lukka, Tuomo.Lukka@iki.fi
  *
  * DaoGen license: The following DaoGen generated source code is licensed
  * under the terms of GNU GPL license. The full text for license is available
  * in GNU project's pages: http://www.gnu.org/copyleft/gpl.html
  *
  * If you wish to use the DaoGen generator to produce code for closed-source
  * commercial applications, you must pay the lisence fee. The price is
  * 5 USD or 5 Eur for each database table, you are generating code for.
  * (That includes unlimited amount of iterations with all supported languages
  * for each database table you are paying for.) Send mail to
  * "Tuomo.Lukka@iki.fi" for more information. Thank you!
  */



public class Res implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int res_id;
    private Time res_hora_ini;
    private Time res_hora_fin;
    private int res_id_sal;
    private int res_id_doc;
    private java.sql.Date res_fecha;
    private Timestamp timestamp;
    private int token;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Res () {

    }

    
    public Res (int token) {

          this.token = token;

    }
    


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getRes_id() {
          return this.res_id;
    }
    public void setRes_id(int res_idIn) {
          this.res_id = res_idIn;
    }

    public Time getRes_hora_ini() {
          return this.res_hora_ini;
    }
    public void setRes_hora_ini(Time res_hora_iniIn) {
          this.res_hora_ini = res_hora_iniIn;
    }

    public Time getRes_hora_fin() {
          return this.res_hora_fin;
    }
    public void setRes_hora_fin(Time res_hora_finIn) {
          this.res_hora_fin = res_hora_finIn;
    }

    public int getRes_id_sal() {
          return this.res_id_sal;
    }
    public void setRes_id_sal(int res_id_salIn) {
          this.res_id_sal = res_id_salIn;
    }

    public int getRes_id_doc() {
          return this.res_id_doc;
    }
    public void setRes_id_doc(int res_id_docIn) {
          this.res_id_doc = res_id_docIn;
    }

    public java.sql.Date getRes_fecha() {
          return this.res_fecha;
    }
    public void setRes_fecha(java.sql.Date res_fechaIn) {
          this.res_fecha = res_fechaIn;
    }

    public Timestamp getTimestamp() {
          return this.timestamp;
    }
    public void setTimestamp(Timestamp timestampIn) {
          this.timestamp = timestampIn;
    }

    public int getToken() {
          return this.token;
    }
    public void setToken(int tokenIn) {
          this.token = tokenIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int res_idIn,
          Time res_hora_iniIn,
          Time res_hora_finIn,
          int res_id_salIn,
          int res_id_docIn,
          java.sql.Date res_fechaIn,
          Timestamp timestampIn,
          int tokenIn) {
          this.res_id = res_idIn;
          this.res_hora_ini = res_hora_iniIn;
          this.res_hora_fin = res_hora_finIn;
          this.res_id_sal = res_id_salIn;
          this.res_id_doc = res_id_docIn;
          this.res_fecha = res_fechaIn;
          this.timestamp = timestampIn;
          this.token = tokenIn;
    }


    /** 
     * hasEqualMapping-method will compare two Res instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Res valueObject) {

          if (valueObject.getRes_id() != this.res_id) {
                    return(false);
          }
          if (this.res_hora_ini == null) {
                    if (valueObject.getRes_hora_ini() != null)
                           return(false);
          } else if (!this.res_hora_ini.equals(valueObject.getRes_hora_ini())) {
                    return(false);
          }
          if (this.res_hora_fin == null) {
                    if (valueObject.getRes_hora_fin() != null)
                           return(false);
          } else if (!this.res_hora_fin.equals(valueObject.getRes_hora_fin())) {
                    return(false);
          }
          if (valueObject.getRes_id_sal() != this.res_id_sal) {
                    return(false);
          }
          if (valueObject.getRes_id_doc() != this.res_id_doc) {
                    return(false);
          }
          if (this.res_fecha == null) {
                    if (valueObject.getRes_fecha() != null)
                           return(false);
          } else if (!this.res_fecha.equals(valueObject.getRes_fecha())) {
                    return(false);
          }
          if (this.timestamp == null) {
                    if (valueObject.getTimestamp() != null)
                           return(false);
          } else if (!this.timestamp.equals(valueObject.getTimestamp())) {
                    return(false);
          }
          if (valueObject.getToken() != this.token) {
                    return(false);
          }

          return true;
    }



    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Res, mapping to table reserva\n");
        out.append("Persistent attributes: \n"); 
        out.append("res_id = " + this.res_id + "\n"); 
        out.append("res_hora_ini = " + this.res_hora_ini + "\n"); 
        out.append("res_hora_fin = " + this.res_hora_fin + "\n"); 
        out.append("res_id_sal = " + this.res_id_sal + "\n"); 
        out.append("res_id_doc = " + this.res_id_doc + "\n"); 
        out.append("res_fecha = " + this.res_fecha + "\n"); 
        out.append("timestamp = " + this.timestamp + "\n"); 
        out.append("token = " + this.token + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Res cloned = new Res();

        cloned.setRes_id(this.res_id); 
        if (this.res_hora_ini != null)
             cloned.setRes_hora_ini((Time)this.res_hora_ini.clone()); 
        if (this.res_hora_fin != null)
             cloned.setRes_hora_fin((Time)this.res_hora_fin.clone()); 
        cloned.setRes_id_sal(this.res_id_sal); 
        cloned.setRes_id_doc(this.res_id_doc); 
        if (this.res_fecha != null)
             cloned.setRes_fecha((java.sql.Date)this.res_fecha.clone()); 
        if (this.timestamp != null)
             cloned.setTimestamp((Timestamp)this.timestamp.clone()); 
        cloned.setToken(this.token); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}
