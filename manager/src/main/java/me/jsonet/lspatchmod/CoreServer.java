package me.jsonet.lspatchmod;

import android.os.RemoteException;

import org.lsposed.patch.LSPatch;

import java.io.File;

public class CoreServer {

    public void patch(String path, String topath) throws RemoteException {
        try {
            new LSPatch().patch(new File(path), new File(topath));
        } catch (Exception ignored) {
        }
    }
}
