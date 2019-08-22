// IRemoteService.aidl
package com.app.suit.customviewp;
import com.app.suit.customviewp.entity.MyData;

// Declare any non-default types here with import statements
interface IRemoteService {
     int getPid();
     MyData getMyData();
}
