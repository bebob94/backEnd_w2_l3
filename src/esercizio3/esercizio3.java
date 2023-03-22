package esercizio3;

	import java.io.File;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import org.apache.commons.io.FileUtils;

	
	public class esercizio3 {

	    private List<Presenza> presenze;

	    public esercizio3() {
	        presenze = new ArrayList<>();
	    }

	    public void aggiungiPresenza(String nome, int giorni) {
	        presenze.add(new Presenza(nome, giorni));
	    }

	    public void salvaPresenzeSuFile(File file) throws IOException {
	        StringBuilder sb = new StringBuilder();
	        for (Presenza p : presenze) {
	            sb.append(p.getNome()).append("@").append(p.getGiorni()).append("#");
	        }
	        FileUtils.writeStringToFile(file, sb.toString(), "UTF-8");
	    }

	    public void caricaPresenzeDaFile(File file) throws IOException {
	        String data = FileUtils.readFileToString(file, "UTF-8");
	        String[] presenzeStringhe = data.split("#");
	        for (String p : presenzeStringhe) {
	            String[] tokens = p.split("@");
	            String nome = tokens[0];
	            int giorni = Integer.parseInt(tokens[1]);
	            presenze.add(new Presenza(nome, giorni));
	        }
	    }

	    private static class Presenza {
	        private String nome;
	        private int giorni;

	        public Presenza(String nome, int giorni) {
	            this.nome = nome;
	            this.giorni = giorni;
	        }

	        public String getNome() {
	            return nome;
	        }

	        public int getGiorni() {
	            return giorni;
	        }
	    }
	}