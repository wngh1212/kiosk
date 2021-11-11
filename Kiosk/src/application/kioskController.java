package application;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class kioskController implements Initializable {
	@FXML Button btnM1p,btnM1m,btnM2p,btnM2m,btnM3p,btnM3m,btnM4p1,btnM4m1,btnOrder,btnCancel,openscreen;
	@FXML Label lblamount;
	@FXML TextArea txtOrder;
	public int sum=0;
	private String[] orderm = {"콜라(단품)","팝콘(M)","classic set(팝콘L)","패밀리 set"};
	private int[] countm = new int[4];
	private Amountmodel model = new Amountmodel();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		for(int i=0; i<4; i++) countm[i]=0;
	}
	public void menuAppend() {
		txtOrder.setText("");
		for(int i=0; i<4;i++) {
			if(countm[i] !=0) txtOrder.appendText(orderm[i] + " " + countm[i]+"개"+"\n");
		}
}
public void btnM1pAction(ActionEvent event) {
	countm[0]++;
	menuAppend();
}
public void btnM1mAction(ActionEvent event) {
	if(countm[0]>0) countm[0]--;
	else countm[0]=0;
	menuAppend();
}
public void btnM2pAction(ActionEvent event) {
	countm[1]++;
	menuAppend();
}
public void btnM2mAction(ActionEvent event) {
	if(countm[1]>0) countm[1]--;
	else countm[1]=0;
	menuAppend();
}
public void btnM3pAction(ActionEvent event) {
	countm[2]++;
	menuAppend();
}
public void btnM3mAction(ActionEvent event) {
	if(countm[2]>0) countm[2]--;
	else countm[2]=0;
	menuAppend();
}
public void btnM4pAction(ActionEvent event) {
	countm[3]++;
	menuAppend();
}
public void btnM4mAction(ActionEvent event) {
	if(countm[3]>0) countm[3]--;
	else countm[3]=0;
	menuAppend();
}
public void btnOrderAction(ActionEvent event) {
	DecimalFormat df = new DecimalFormat("#,###");
	sum = model.asum(countm);
	lblamount.setText(df.format(sum));
}
public void btnCancelAction(ActionEvent event) {
	for(int i=0; i<3; i++) countm[i]=0;
	txtOrder.setText("");
	lblamount.setText("0");
}
public void openscreen(ActionEvent event) {
		try {
			//BorderPane root = new BorderPane();
			Stage stage = (Stage) openscreen.getScene().getWindow();
			 Parent root = FXMLLoader.load(getClass().getResource("card.fxml"));
			Scene scene = new Scene(root,284,433);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("결재 창");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
}
	}


