package student.uhasselt.be.model;

import student.uhasselt.be.utils.BrowserHome;

import java.net.URL;
import java.util.Observable;

public class BrowserModel extends Observable {
    private URL url;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        if (this.url == null) {
            this.url = url;
            setChanged();
            notifyObservers(this);
        } else {
            if (!(url.toString().equals(this.url.toString()))) {
                this.url = url;
                setChanged();
                notifyObservers(this);
            }
        }

    }
}
