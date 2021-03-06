###### tags: `類神經網路作業 1 :設計感知機類神經網路`
# Perceptron

1. 程式執行說明:
   執行檔**perceptron.jar**要用命令題示字元開啟，並且要先下載JavaFX:
>    java --module-path "C:\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar perceptron.jar
   
2. 執行介面說明:

   ![](https://i.imgur.com/B4vIPEf.png)
    * 左方可選擇檔案。
    * 左下方可勾選初始鍵結值是否為(-1,0,1)，若沒有勾選，則初始鍵結值為(-1, 0 ~ 1 隨機, 0 ~ 1隨機 )。
    * 上方可調整學習率( 0 ~ 1 )與收斂條件(學習次數:200~3500)。
    * 結果會顯示於中間座標中。
    * 右方會顯示訓練結果(鍵結值、訓練辨識率、測試辨識率)

3. 執行結果說明:

   ![](https://i.imgur.com/ByKRf1h.png)
    * 座標上的點，深色為訓練資料，淺色為測試資料，藍色為第一類資料，綠色為第二類資料，橘色為第三類資料(深藍:期望輸出為第一類的訓練資料；淺藍:期望輸出為第一類的測試資料；深綠:期望輸出為第二類的訓練資料；淺綠:期望輸出為第二類的測試資料；深橘:期望輸出為第三類的訓練資料；淺橘:期望輸出為第三類的測試資料)。
    * 以紅色邊的點表示錯誤分類。
    * 紅線表示依照鍵結值所畫出兩類的分割線。
4. 程式碼簡介:
   程式用Java編寫，使用JavaFX與scene builder的GUI完成最後結果。
    * 程式碼分為兩個檔案
        * perceptron: 為主程式檔，讀取fxml檔並建立GUI。
	    * MainController: 為控制介面的檔案，大部分的運算與操作也在此設定。以下程式碼說明以此檔為主。	
	* 以function分類:
	    * **onSliderChanged_learning_rate()**: 調整學習率，並進行運算顯示結果(Show_point())。
	    * **onSliderChanged_learning_times()**: 調整學習次數，並進行運算顯示結果(Show_point())。
	    * **_perceptron1_button()~ _2ring_button()**: 皆為控制選擇檔案的按鈕的程式碼。將檔案名稱改為所選擇的檔案，並設choose_file為所選擇的檔案，再進行運算顯示結果(Show_point())。
	    * **Show_point()**:	
	        * 進行運算(calculate())。
	        * 顯示出運算結果(鍵結值、訓練辨識率、測試辨識率)
	        * 畫出座標軸
	        * 根據點的座標經過轉換後畫在座標上(轉換目的為將所有點都印在座標上，不會有超出邊界的點。新座標x’=600+原座標x *250/X_Y_max，其中600為座標原點的x座標，250為可容納的最大x座標，X_Y_max為所有原作標x與y中，有出線的最大值。同理新座標y’=400-原座標y *250/X_Y_max，其中400為座標原點的y座標，又因為javafx的座標為越下面越大，因此用”-“的。)
	        * 設定點的半徑(點越多半徑越小)與顏色(代表不同類別資料及訓練或測試資料)。
	        * 畫出單位座標(利用與畫作標點相似的方法)。
	        * 畫出鍵結值向量。
	    * **calculate()**:
	        * 根據所選擇的檔案讀檔。
	        * 初始鍵結值(w=(-1,0~1 random,0~1 random))。
	        * 將讀到的每一筆資料存起來，並記錄有出現的期望輸出值。
	        * 讓每一筆資料隨機排列(Ran_list())。
	        * 判斷有幾筆訓練資料(全部資料的2/3)，幾筆測試資料(全部資料的1/3)。
	        * 進行訓練，紀錄最好的結果。
	        * 根據訓練的結果進行測試，並計算辨識率。
	    * **y_function(double)**:活化函數，得到類神經元的輸出。
	    * **correct_train()**:計算訓練資料的辨識率。
        * **Ran_list()**:打亂原本讀入資料的順序。
