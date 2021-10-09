package nn.hw1.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import nn.hw1.perceptron;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;



public class MainController {
	
	@FXML
	Pane _main_pane;
	@FXML
	CheckBox _w_checkbox;
	@FXML
	Line _line1;
	@FXML
	Line _line2;
	@FXML
	Line _line3;
	@FXML
	Line _line4;
	@FXML
	Line _line5;
	@FXML
	Line _line6;
	@FXML
	Text _synaptic_weights;
	@FXML
	Text _correct_rate_train;
	@FXML
	Text _correct_rate_test;
	@FXML
	Text _choose_file;
	@FXML
	Text _loading;
	@FXML
	Slider _learning_rate;
	@FXML
	Slider _learning_times;
	public void onSliderChanged_learning_rate() throws Exception {
		_loading.setVisible(true);
	    double sliderValue_learning_rate =  _learning_rate.getValue();
	    Learningrate = sliderValue_learning_rate;
	    System.out.println(sliderValue_learning_rate + " ");
	    Show_point();
	}
	public void onSliderChanged_learning_times() throws Exception {
		_loading.setVisible(true);
	    int sliderValue_learning_times =  (int) _learning_times.getValue();
	    learning_time = sliderValue_learning_times;
	    System.out.println(sliderValue_learning_times + " ");
	    Show_point();
	}
	public void Check_W() throws Exception {
		_loading.setVisible(true);
		Show_point();
	}
	
	//var
	public static int MAX_TERM=1000;
	public static int []y_output;
	public static int []y_output_best;
	public static int output1=20,output2=20,output3=20;
	public static double[][] data_x = new double[MAX_TERM][3];
	public static int[] desire_output=new int[MAX_TERM];//0 or 1
	public static int n=0;//the number of data
	public static int n_test;
	public static int n_train;
	public static double Learningrate=0.8 ;
	public static double []W_now= {-1,0,1};
	public static double []W_best= {-1,0,1};
	public static double output;
	public static int learning_time=800;
	public static double correct_rate_best=0;
	public static double correct_rate_test=0;
	public static double correct_rate_now=0;
	public static Scanner input;
	public static double X_Y_max=2;
	public static double slope=0;
	public static int choose_file=0;
	public static int []R_list;
	public static boolean []R_list_find;
	 //read File
	public static File _perceptron1 = new File("File/perceptron1.txt");//2D
	public static File _perceptron2 = new File("File/perceptron2.txt");//2D		
	public static File _2Ccircle1 = new File("File/2Ccircle1.txt");//2D		
	public static File _2Circle1 = new File("File/2Circle1.txt");//2D		
	public static File _2Circle2 = new File("File/2Circle2.txt");//2D		
	public static File _2CloseS = new File("File/2CloseS.txt");//2D		
	public static File _2CloseS2 = new File("File/2CloseS2.txt");//2D
	public static File _2CloseS3 = new File("File/2CloseS3.txt");//2D
	public static File _2cring = new File("File/2cring.txt");//2D
	public static File _2CS = new File("File/2CS.txt");//2D
	public static File _2Hcircle1 = new File("File/2Hcircle1.txt");//2D
	public static File _2ring = new File("File/2ring.txt");//2D
	
	
	public void _perceptron1_button(ActionEvent e) throws Exception  {
		_loading.setVisible(true);
		_choose_file.setText("perceptron1");
		//input=new Scanner(_perceptron1);
		choose_file=0;
		Show_point();
		//calculate();
		//_correct_rate.setText("Correct rate: " + correct_rate_best*100 +"%");
		//_synaptic_weights.setText("Synaptic Weights: " + "W= ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
	}
	
	public void _perceptron2_button(ActionEvent e) throws Exception {
		_loading.setVisible(true);
		_choose_file.setText("perceptron2");
		//input=new Scanner(_perceptron2);
		choose_file=1;
		Show_point();
		//calculate();
		//_correct_rate.setText("Correct rate: " + correct_rate_best*100 +"%");
		//_synaptic_weights.setText("Synaptic Weights: " + "W= ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
		
	}
	public void _2Ccircle1_button(ActionEvent e) throws Exception {
		_loading.setVisible(true);
		_choose_file.setText("2Ccircle1");
		//input=new Scanner(_2Ccircle1);
		choose_file=2;
		Show_point();
		//calculate();
		//_correct_rate.setText("Correct rate: " + correct_rate_best*100 +"%");
		//_synaptic_weights.setText("Synaptic Weights: " + "W= ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
	}
	public void _2Circle1_button(ActionEvent e) throws Exception {
		_loading.setVisible(true);
		_choose_file.setText("2Circle1");
		//input=new Scanner(_2Circle1);
		choose_file=3;
		Show_point();
		//calculate();
		//_correct_rate.setText("Correct rate: " + correct_rate_best*100 +"%");
		//_synaptic_weights.setText("Synaptic Weights: " + "W= ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
	}
	public void _2Circle2_button(ActionEvent e) throws Exception {
		_loading.setVisible(true);
		_choose_file.setText("2Circle2");
		//input=new Scanner(_2Circle2);
		choose_file=4;
		Show_point();
		//calculate();
		//_correct_rate.setText("Correct rate: " + correct_rate_best*100 +"%");
		//_synaptic_weights.setText("Synaptic Weights: " + "W= ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
	}
	public void _2CloseS_button(ActionEvent e) throws Exception {
		_loading.setVisible(true);
		_choose_file.setText("2CloseS");
		//input=new Scanner(_2CloseS);
		choose_file=5;
		Show_point();
		//calculate();
		//_correct_rate.setText("Correct rate: " + correct_rate_best*100 +"%");
		//_synaptic_weights.setText("Synaptic Weights: " + "W= ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
	}
	public void _2CloseS2_button(ActionEvent e) throws Exception {
		_loading.setVisible(true);
		_choose_file.setText("2CloseS2");
		//input=new Scanner(_2CloseS2);
		choose_file=6;
		Show_point();
		//calculate();
		//_correct_rate.setText("Correct rate: " + correct_rate_best*100 +"%");
		//_synaptic_weights.setText("Synaptic Weights: " + "W= ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
	}
	public void _2CloseS3_button(ActionEvent e) throws Exception {
		_loading.setVisible(true);
		_choose_file.setText("2CloseS3");
		//input=new Scanner(_2CloseS3);
		choose_file=7;
		Show_point();
		//calculate();
		//_correct_rate.setText("Correct rate: " + correct_rate_best*100 +"%");
		//_synaptic_weights.setText("Synaptic Weights: " + "W= ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
	}
	public void _2cring_button(ActionEvent e) throws Exception {
		_loading.setVisible(true);
		_choose_file.setText("2cring");
		//input=new Scanner(_2cring);
		choose_file=8;
		Show_point();
		//calculate();
		//_correct_rate.setText("Correct rate: " + correct_rate_best*100 +"%");
		//_synaptic_weights.setText("Synaptic Weights: " + "W= ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
	}
	public void _2CS_button(ActionEvent e) throws Exception {
		_loading.setVisible(true);
		_choose_file.setText("2CS");
		//input=new Scanner(_2CS);
		choose_file=9;
		Show_point();
		//calculate();
		//_correct_rate.setText("Correct rate: " + correct_rate_best*100 +"%");
		//_synaptic_weights.setText("Synaptic Weights: " + "W= ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
	}
	public void _2Hcircle1_button(ActionEvent e) throws Exception {
		_loading.setVisible(true);
		_choose_file.setText("2Hcircle1");
		//input=new Scanner(_2Hcircle1);
		choose_file=10;
		Show_point();
		//calculate();
		//_correct_rate.setText("Correct rate: " + correct_rate_best*100 +"%");
		//_synaptic_weights.setText("Synaptic Weights: " + "W= ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
	}
	public void _2ring_button(ActionEvent e) throws Exception {
		_loading.setVisible(true);
		_choose_file.setText("2ring");
		//input=new Scanner(_2ring);
		choose_file=11;
		Show_point();
		//calculate();
		//_correct_rate.setText("Correct rate: " + correct_rate_best*100 +"%");
		//_synaptic_weights.setText("Synaptic Weights: " + "W= ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
		
	}
	public void Show_point() throws Exception  {	
		
		W_now[0]= -1;
		W_now[1]= Math.random();
		W_now[2]= Math.random();
		if( _w_checkbox.isSelected())
		{
			W_now[1]= 0;
			W_now[2]= 1;
		}
		calculate();
		_correct_rate_train.setText("Correct rate train: \n" + correct_rate_best*100 +"%");
		_correct_rate_test.setText("Correct rate test: \n" + correct_rate_test*100 +"%");
		_synaptic_weights.setText("Synaptic Weights: \n" + "W= ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
		
		Rectangle Axis_board =new Rectangle(275,75,650,650);
		Axis_board.setStroke(Color.BLACK);
		Axis_board.setFill(Color.MINTCREAM);
		_main_pane.getChildren().add(Axis_board);
		
		Line lineX = new Line(300,400,900,400);
		lineX.setStrokeWidth(1);
		lineX.setStroke(Color.BLACK);
		
		Line lineY = new Line(600,100,600,700);
		lineY.setStrokeWidth(1);
		lineY.setStroke(Color.BLACK);
		
		Line lineX_up = new Line(900,400,880,380);
		lineX_up.setStrokeWidth(1);
		lineX_up.setStroke(Color.BLACK);
		
		Line lineX_down = new Line(900,400,880,420);
		lineX_down.setStrokeWidth(1);
		lineX_down.setStroke(Color.BLACK);
		
		Line lineY_left = new Line(600,100,620,120);
		lineY_left.setStrokeWidth(1);
		lineY_left.setStroke(Color.BLACK);
		
		Line lineY_right = new Line(600,100,580,120);
		lineY_right.setStrokeWidth(1);
		lineY_right.setStroke(Color.BLACK);
		
		
		
		_main_pane.getChildren().addAll(lineX,lineY,lineX_up,lineX_down,lineY_left,lineY_right);
		for(int i=0;i<n;i++) {
			Circle point = new Circle();
			point.setCenterX(600+data_x[R_list[i]][1]*250/X_Y_max);
			point.setCenterY(400-data_x[R_list[i]][2]*250/X_Y_max);
			if(n<=50)
			{
				point.setRadius(5);
			}else if(n<=500)
			{
				point.setRadius(3);
			}else
			{
				point.setRadius(2.75);
			}
			
			if(i>=n_train)//test
			{
				if(desire_output[R_list[i]]==y_output_best[R_list[i]])//correct
				{
					point.setStroke(Color.SLATEBLUE);
				}else//wrong
				{
					point.setStroke(Color.RED);
				}
				
				if(desire_output[R_list[i]]==output1)
				{
					point.setFill(Color.ALICEBLUE);
				}else
				{
					if(desire_output[R_list[i]]==output2)
					{
						point.setFill(Color.LIGHTGREEN);
					}else
					{
						point.setFill(Color.YELLOW);
					}
					
				}
			}else//train
			{
				if(desire_output[R_list[i]]==y_output_best[R_list[i]])
				{
					point.setStroke(Color.SLATEBLUE);
				}else
				{
					point.setStroke(Color.RED);
				}
				
				if(desire_output[R_list[i]]==output1)
				{
					point.setFill(Color.CORNFLOWERBLUE);
				}else
				{
					if(desire_output[R_list[i]]==output2)
					{
						point.setFill(Color.DARKGREEN);
					}else
					{
						point.setFill(Color.ORANGE);
					}
				}
			}
			
			_main_pane.getChildren().add(point);
		}
		//unit
		Line X_unit = new Line(600+250/X_Y_max,392,600+250/X_Y_max,408);
		X_unit.setStrokeWidth(1);
		X_unit.setStroke(Color.BLACK);
		
		Line Y_unit = new Line(592,400-250/X_Y_max,608,400-250/X_Y_max);
		Y_unit.setStrokeWidth(1);
		Y_unit.setStroke(Color.BLACK);
		
		Text X_1 = new Text(597+250/X_Y_max,420,"1");
		Text Y_1 = new Text(580,403-250/X_Y_max,"1");
		
		//draw W
		_main_pane.getChildren().addAll(X_unit,Y_unit,X_1,Y_1);
		//W_best[0]+", "+ W_best[1]+", "+ W_best[2]
		Polyline W_seperate = new Polyline();
		W_seperate.setFill(Color.WHITE);
		W_seperate.setStroke(Color.RED);
		double y_transport=0;
		ObservableList<Double> list =W_seperate.getPoints();
		//System.out.println("W(draw line)= ("+W_best[0]+", "+ W_best[1]+", "+ W_best[2]+" )");
		for(double i=0;i<600;i=i+0.1)
		{
			//vertical
			y_transport=(((double)i+300-600)*X_Y_max*W_best[1]-250*W_best[0])/(X_Y_max*W_best[2])+400;
			if(y_transport>=100 && y_transport<=700)
			{
				list.add(300+(double)i);
				list.add(y_transport);
				//System.out.println("(X,Y): ("+(300+i)+" , "+y_transport+" )");
			}
			
		}
		_main_pane.getChildren().add(W_seperate);
		_loading.setVisible(false);
		
	}
	//draw x,y Axis
	public static void calculate() throws Exception{
		//input = new Scanner(_2Hcircle1);//need to change
		//System.out.println("IN calculate");
		switch(choose_file)
		{
		case 0:
			input=new Scanner(_perceptron1);
			break;
		case 1:
			input=new Scanner(_perceptron2);
			break;
		case 2:
			input=new Scanner(_2Ccircle1);
			break;
		case 3:
			input=new Scanner(_2Circle1);
			break;
		case 4:
			input=new Scanner(_2Circle2);
			break;
		case 5:
			input=new Scanner(_2CloseS);
			break;
		case 6:
			input=new Scanner(_2CloseS2);
			break;
		case 7:
			input=new Scanner(_2CloseS3);
			break;
		case 8:
			input=new Scanner(_2cring);
			break;
		case 9:
			input=new Scanner(_2CS);
			break;
		case 10:
			input=new Scanner(_2Hcircle1);
			break;
		case 11:
			input=new Scanner(_2ring);
			break;
		}
		//initial
		output1=20;
		output2=20;
		n=0;
		X_Y_max=2;
		//Learningrate = 0.8 ;
		double tmp;
		int tmp2;
		
		W_best[0]= W_now[0];
		W_best[1]= W_now[1];
		W_best[2]= W_now[2];
		  		
		//int arraylength = input.nextInt();
		  		
		// TODO Auto-generated method stub
		  		
		//put input into array
		while (input.hasNext())
		{
			data_x[n][0] =-1; 
			tmp=input.nextDouble();
			data_x[n][1] =tmp; //x1
			//System.out.println("data_x[n][1]: "+ data_x[n][1]);
			if(data_x[n][1]>X_Y_max)
			{
				X_Y_max=data_x[n][1];
			}else if((-1)*data_x[n][1]>X_Y_max)
			{
				X_Y_max=(-1)*data_x[n][1];
			}
			
			tmp=input.nextDouble();
			data_x[n][2] =tmp; //x2
			if(data_x[n][2]>X_Y_max)
			{
				X_Y_max=data_x[n][2];
			}else if((-1)*data_x[n][2]>X_Y_max)
			{
				X_Y_max=(-1)*data_x[n][2];
			}
			
			tmp2=input.nextInt();
			desire_output[n]=tmp2;//d
			if(output1==20)
			{
				output1=tmp2;
				//System.out.println("output1: "+ output1);
			}		
			else if(output1!=tmp2 && output2==20)
		    {
		  		output2=tmp2;
		  		//System.out.println("output2: "+ output2);
		  				
		  	}else if(output2!=tmp2 && output3==20)
		    {
		  		output3=tmp2;
		  		//System.out.println("output2: "+ output2);
		  				
		  	}
		  	n++;
		 }
		 
		 
		
		
		 //out put the file has read
		 for(int i=0;i<n;i++ )
		 {
			 System.out.println(i+"\t"+data_x[i][0]+"\t"+data_x[i][1]+"\t"+data_x[i][2]+"\t"+desire_output[i]);
			 
		  			
		 }
		 Ran_list();
		 
		 for(int i=0;i<n;i++ )
		 {
			 System.out.println("R_list "+i+" :"+ R_list[i]);
		 }
		 //initial
		  	
		 
		 y_output=new int[n];//output1 or output2
		 y_output_best=new int[n];
		 correct_rate_best=0;
		 correct_rate_now=0;
		 if(n%3==0)
		 {
			 n_test=n/3;
		 }else if(n%3==1)
		 {
			 n_test=(n-1)/3;
		 }else
		 {
			 n_test=(n-2)/3;
		 }
		 n_train=n-n_test;
		 //System.out.println("n: " + n);
		 //System.out.println("n_train: " + n_train);
		 //System.out.println("n_test: " + n_test);
		 
		 correct_rate_best=correct_train()/n_train;
		 //System.out.println("correct_rate_best: " + correct_rate_best);
		 for(int times=0;times<learning_time;times++)
		 {
			 //System.out.println("In train");
			for(int i=0;i<n_train;i++)//train
		  	{
		  		
		  			output = W_best[0]*data_x[R_list[i]][0] + W_best[1]*data_x[R_list[i]][1] + W_best[2]*data_x[R_list[i]][2];
			  		//System.out.println("output " + i+": " + output);
			  		y_output[R_list[i]]=y_function(output);
			  		if(y_output[R_list[i]]!=desire_output[R_list[i]])
			  		{
			  			//System.out.println("Need to change. " );
			  			if(output>=0)
			  			{
			  				W_now[0]= W_best[0]-Learningrate*data_x[R_list[i]][0];
			  				//System.out.println("W[0]: " +W_best[0]+"-"+Learningrate+"*"+data_x[i][0]+"="+W_now[0]);
			  				W_now[1]= W_best[1]-Learningrate*data_x[R_list[i]][1];
			  				//System.out.println("W[1]: " +W_best[1]+"-"+Learningrate+"*"+data_x[i][1]+"="+W_now[1]);
			  				W_now[2]= W_best[2]-Learningrate*data_x[R_list[i]][2];	
			  				//System.out.println("W[2]: " +W_best[2]+"-"+Learningrate+"*"+data_x[i][2]+"="+W_now[2]);
			  				//System.out.println("W: ( " + W_now[0]+", "+ W_now[1]+", "+ W_now[2]+")");
			  			}else
			  			{
			  				W_now[0]= W_best[0]+Learningrate*data_x[R_list[i]][0];
			  				W_now[1]= W_best[1]+Learningrate*data_x[R_list[i]][1];
			  				W_now[2]= W_best[2]+Learningrate*data_x[R_list[i]][2];
			  				//System.out.println("W: ( " + W_now[0]+", "+ W_now[1]+", "+ W_now[2]+")");
			  			}
			  			correct_rate_now=correct_train()/n_train;
			  			if(correct_rate_now >= correct_rate_best)
			  			{
			  				W_best[0]=W_now[0];
			  				W_best[1]=W_now[1];
			  				W_best[2]=W_now[2];
			  				correct_rate_best = correct_rate_now;
			  				if(correct_rate_best>=0.99)
			  					break;
			  			}
			  		}
		  		
		  	}
		  	if(correct_rate_best>=0.99)
		  		break;
		  	//Learningrate=Learningrate-0.002;
		 }
		
		//test 
		int correct_test=0;
		//System.out.println("W(in_correct): ( " + W_now[0]+", "+ W_now[1]+", "+ W_now[2]+")");
		
		for(int i=n_train;i<n;i++)
		{
			output = W_best[0]*data_x[R_list[i]][0] + W_best[1]*data_x[R_list[i]][1] + W_best[2]*data_x[R_list[i]][2];
			y_output[R_list[i]]=y_function(output);
			if(y_output[R_list[i]]==desire_output[R_list[i]])
			{
				correct_test++;
				//System.out.println("correct_test (i)=  " + i);
			}
			
		}
		correct_rate_test=correct_test/(double)n_test;
		
		 for(int i=0;i<n;i++)
		 {
			 output = W_best[0]*data_x[i][0] + W_best[1]*data_x[i][1] + W_best[2]*data_x[i][2];
			 y_output_best[i]=y_function(output);
		 }
		 //System.out.println("W: ( " + W_best[0]+", "+ W_best[1]+", "+ W_best[2]+")");
		 //System.out.println("correct rate: " + correct_rate_best);
		 

	}
	public static int y_function(double in) {
		if(in >= 0)
		{
			//System.out.println("inoutput1: " + output1);
			return output1;
		}else
		{
			//System.out.println("inoutput2: " +output2);
			return output2;
		}
			
	}
	public static double correct_train() {//calculate correct rate
		int correct=0;
		//System.out.println("W(in_correct): ( " + W_now[0]+", "+ W_now[1]+", "+ W_now[2]+")");
		for(int i=0;i<n_train;i++)
		{
			output = W_now[0]*data_x[R_list[i]][0] + W_now[1]*data_x[R_list[i]][1] + W_now[2]*data_x[R_list[i]][2];
			y_output[R_list[i]]=y_function(output);
			if(y_output[R_list[i]]==desire_output[R_list[i]])
			{
				correct++;
			}
			
		}
		//System.out.println("correct: " + correct);
		//System.out.println("n_train: " + n_train);
		return correct;
	}
	public static void Ran_list() {//calculate correct rate
		R_list = new int[n];
		R_list_find=new boolean[n];
		for(int i=0;i<n;i++)
		{
			R_list_find[i]=false;
		}
		int find=0;
		int temp=0;
		for(int i=0;i<n;i++)
		{
			
			temp= temp+(int)(1000*Math.random());
			
			//System.out.println("temp"+i+": " + temp);
			while(true)
			{
				temp=temp%n;
				if(!R_list_find[temp])
				{
					R_list[temp]=i;
					//System.out.println("R_list["+temp+"]: " + R_list[temp]);
					R_list_find[temp]=true;
					break;
				}else
				{
					temp++;
				}
			}
		}
	}
	
}
