package pk.foto;

public class FotoVerwaltung {

    Album[] alben = new Album[2];

    public void druckeAlleAlben() {
    	
    	for (int i = 0; i < alben.length; i++)
    		System.out.print(String.format("=== Album %s ===\n%s", i+1, alben[i]));
    }

    public int gibAnzahlAlben() {
    	int i = 0;
    	for(Album album: alben) 
    		if (album != null)
    			i++;
    	
    	return i;
    }

    public Album[] gibAlleAlben() {
    	Album[] alleAlben = new Album[gibAnzahlAlben()];
    	int j = 0;
    	
    	for (int i = 0; i < alben.length; i++) 
    		if (alben[i] != null) 
    			alleAlben[j++] = alben[i];
    		
    	return alleAlben;
    }

    public void addAlbum(Album album) {
    	int i;

		for (i = 0; i < alben.length; i++) {
			if (alben[i] == null) {
				alben[i] = album;
				return;
			}
		}

		Album[] albenNeu = new Album[alben.length + 1];

		for (int j = 0; j < alben.length; j++)
			albenNeu[j] = alben[j];

		albenNeu[alben.length] = album;

		alben = albenNeu;
    }

    public Album findeAlbumMitName(String name) {
    	if (name == null)
    		return null;
    	
    	for (Album album: alben)
    		if (album.getName() == name)
    			return album;
    	
    	return null;
    }
}
