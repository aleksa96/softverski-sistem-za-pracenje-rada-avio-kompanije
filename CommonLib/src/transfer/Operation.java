/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

/**
 *
 * @author Aleksa
 */
public interface Operation {

    public static final int TEST = 1;
    public static final int SERVERSTATUS = 2;
    public static final int LOGIN = 3;
    public static final int GETCOUNTRY = 4;
    public static final int GETAIRPLANE = 5;
    public static final int GETAIRPORT = 6;
    public static final int ADDNEWPASSENGER = 7;
    public static final int GETPASSENGER = 8;
    public static final int GETCOUNTRYTOCHANGE = 9;
    public static final int CHANGEPASSENGER = 10;
    public static final int DELETEPASSENGER = 11;
    public static final int GETFLIGHT = 12;
    public static final int ADDNEWFLIGHT = 13;
    public static final int DELETEFLIGHT = 14;
    public static final int GETFLIGHTCLASS = 15;
    public static final int GETCMBFLIGHT = 16;
    public static final int GETRESERVATION = 17;
    public static final int GETPASSENGERTOSELECT = 18;
    public static final int ADDRESERVATION = 19;
    public static final int DELETERESERVATION = 20;
    public static final int GETPASSANGERGROUP = 21;
    public static final int SAVEGROUPRESERVATION = 22;
}
