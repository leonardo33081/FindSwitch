package br.com.cabal.findswitch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class ItemWindow extends Window {
	private static final long serialVersionUID = -6870465023809001089L;
	
	  public ItemWindow (String caption) {
	        super(caption);
	        setWidth("960px");
	        //setHeight("800px");
	        setModal(true);
	        setResizable(true);
	        setSizeFull();
	        //(VerticalLayout)getContent()).setSpacing(true);
	        setCloseShortcut(ShortcutAction.KeyCode.ESCAPE);
	    }
	  
	  protected String trataInformacaoString(String info){
		  String resposta = "Inexistente";
		  if(info == null)
			  return resposta;
		  else return info;
	  }
	  protected Object trataInformacaoObject(Object info){
		  String resposta = "Inexistente";
		  if(info == null)
			  return resposta;
		  else return info;
	  }
		protected String getDataString(Date d) {
			String resposta = "Inexistente";
			if(d==null)
				return resposta;
			
			DateFormat df=null;
			try{
				df = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
				resposta = df.format(d);
				System.out.println(resposta);
			}catch(Exception e){
				System.out.println("Erro na conversão de datas. Erro = " + e.getMessage());
			}
				return resposta;
		}
}
