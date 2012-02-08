/**
 * 
 */
package de.offis.health.icardea.ppm;




import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;
/**
 * @author thiel
 *
 */
public class PPMMain extends ViewPart {

	static public TabFolder mainTabFolder;
	public TabItem[] tabItems; 
	public TabItem tbtmOverview;
	public TabItem tbtmPatinfo;
	private PPMDataset ppmDataset;
	public Composite composite_1;
	public Label lblNewLabel;
	public Label lblNewLabel_1;
	public Label lblNewLabel_2;
	public TabItem tbtmTest;
	public ScrolledComposite scrolledComposite;
	public ArrayList<Button> buttonList;

	public TableViewer tableViewer;
	private static Logger logger = Logger.getLogger(PPMMain.class);

	/**
	 * 
	 */
	public PPMMain() {

		ppmDataset= PPMDataset.getInstance();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		{ 
			parent.setLayout(new FillLayout());
			int numSheets= ppmDataset.getSheetStrings().length;
			//			buttonList=new ArrayList();
			mainTabFolder = new TabFolder(parent, SWT.NONE);
			String[] header ={"Description","Current Values","Subitems"};
			boolean useTable=true;
			boolean fullView=false;//FIXME FULLVIEW CHANGEABLE



			if (useTable) for (int is=0;is<numSheets;is++){	
				Composite composite;
				Table table;

				TabItem tbtm = new TabItem(mainTabFolder, SWT.NONE);
				tbtm.setText(ppmDataset.getSheetStrings()[is]);

				composite = new Composite(mainTabFolder, SWT.NONE);
				tbtm.setControl(composite);
				TableColumnLayout layout = new TableColumnLayout();
				//					composite.setLayout(new FillLayout());
				composite.setLayout(layout);

				tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION|SWT.V_SCROLL);
				table = tableViewer.getTable();

				//				table = new Table(composite, SWT.BORDER |SWT.V_SCROLL);

				table.setLinesVisible(true);
				table.setHeaderVisible(true);


				{
					TableColumn column ;
					TableViewerColumn vcolumn =new TableViewerColumn(tableViewer, SWT.LEFT);
					column = vcolumn.getColumn();

					//					column = new TableColumn(table, SWT.LEFT);
					//					column.setWidth(40);
					//					column.setResizable(true);
					layout.setColumnData(column, new ColumnWeightData( 80,80,false));
					column.setText(header[0]);
				}
				{
					TableColumn column ;
					TableViewerColumn vcolumn =new TableViewerColumn(tableViewer, SWT.LEFT);
					column = vcolumn.getColumn();

					//					column.setWidth(200);
					//					column.setResizable(true);
					layout.setColumnData(column, new ColumnWeightData(200,200,true));
					column.setText(header[1]);
				}
				{	
					TableColumn column ;
					TableViewerColumn vcolumn =new TableViewerColumn(tableViewer, SWT.LEFT);
					column = vcolumn.getColumn();

					//					column.setWidth(40);
					//					column.setResizable(true);
					layout.setColumnData(column, new ColumnWeightData( 40,60,false ));
					column.setText(header[2]);
				}
				PPMRowModel[] allRows= ppmDataset.getRows(ppmDataset.getSheetStrings()[is]);
				PPMSubItemsModel[] allSubRows;
				for (int i=0;i<allRows.length;i++){

					if (!allRows[i].getContent().equalsIgnoreCase("--") |allRows[i].isHasSubcontent() |fullView){
						if (allRows[i].isHasSubcontent())
						{
							TableItem tableItem = new TableItem(table, SWT.NONE);
							boolean subrows=false;
							tableItem.setText(0,allRows[i].getName());
							//							tableItem.setText(1,allRows[i].getContent());
							//						tableItem.setText(2,allRows[i].getSubContentName());
							allSubRows= ppmDataset.getSubItems(allRows[i].getSubContentName());

							if (allSubRows!=null){
								if (allSubRows.length>0){
									subrows=true;
								}}
							if (subrows){
								tableItem.setText(1,allSubRows[allSubRows.length-1].getText());
								//just for testing
								// FARBE COLOR
								{
									Display display = Display.getCurrent();
									//									 display.getSystemColor(SWT.COLOR_DARK_RED);
									logger.trace("Subitem:"+allRows[i].getSubContentName());
									if (ppmDataset.isDemoMode & allRows[i].getSubContentName().equalsIgnoreCase("Compliance")){

										tableItem.setForeground(display.getSystemColor(SWT.COLOR_INFO_BACKGROUND));
										tableItem.setBackground(display.getSystemColor(SWT.COLOR_DARK_RED));
									}
								}

							}else{
								tableItem.setText(1,allRows[i].getContent());

							}
							tableItem.setText(2,"");



							TableEditor editor = new TableEditor(table);
							Button button = new Button(table, SWT.PUSH);
							button.setText(allRows[i].getSubContentName());
							button.addSelectionListener(
									new PPMButtonSelectionAdaptor(allRows[i].getSubContentName(),this.mainTabFolder) 
									);

							button.pack();
							button.setEnabled(subrows);
							editor.minimumWidth = button.getSize().x;
							editor.horizontalAlignment = SWT.LEFT;
							editor.setEditor(button, tableItem, 2);
							//						buttonList.add(button);


						}else {
							//						if (!allRows[i].getContent().equalsIgnoreCase("--"))
							{
								TableItem tableItem = new TableItem(table, SWT.NONE);
								tableItem.setText(0,allRows[i].getName());
								tableItem.setText(1,allRows[i].getContent());
								tableItem.setText(2,""); //allRows[i].getExplanation();
								// FARBE COLOR herer
								
							}

						}
					}
				}
			}


			if(!useTable)	for (int is=0;is<numSheets;is++){
				tbtmTest = new TabItem(mainTabFolder, SWT.NONE);
				tbtmTest.setText(ppmDataset.getSheetStrings()[is]);

				composite_1 = new Composite(mainTabFolder, SWT.V_SCROLL);
				tbtmTest.setControl(composite_1);
				GridLayout gl=new GridLayout(3, false);

				composite_1.setLayout(gl);


				PPMRowModel[] allRows= ppmDataset.getRows(ppmDataset.getSheetStrings()[is]);

				new Label(composite_1, SWT.NONE).setText(header[0]);
				//		new Label(composite_1,SWT.SEPARATOR);
				new Label(composite_1, SWT.NONE).setText(header[1]);
				new Label(composite_1, SWT.NONE).setText(header[2]);


				for (int i=0;i<allRows.length;i++){
					if (!allRows[i].getContent().equalsIgnoreCase("--") |allRows[i].isHasSubcontent() |fullView ){
						Label l1 = new Label(composite_1, SWT.NONE);
						//			new Label(composite_1,SWT.SEPARATOR);
						Label l2 = new Label(composite_1, SWT.LEFT);
						l1.setText(allRows[i].getName()+":");
						l1.setToolTipText(allRows[i].getExplanation());
						l1.setAlignment(SWT.LEFT);
						l2.setText(allRows[i].getContent());
						l2.setToolTipText(allRows[i].getExplanation());
						if (allRows[i].isHasSubcontent())
						{   Button l3 = new Button( composite_1, SWT.PUSH);
						l3.setText(allRows[i].getSubContentName());
						l3.setToolTipText("Press to see further and history data");
						l3.addSelectionListener(
								new PPMButtonSelectionAdaptor(allRows[i].getSubContentName(),this.mainTabFolder) 
								);
						}else {
							Label l3 = new Label(composite_1, SWT.NONE);
							l3.setText("");
						}
					}
					//							System.out.println(allRows[i].getName()+":\t"+allRows[i].getContent());
					//							System.out.println(aktsheet+"#"+i+":"+allRows[i]);
				}
			}


		}
	}
	// TODO Auto-generated method stub


	static void setTabbedFocus(int index){
		if (index<mainTabFolder.getItemCount()){
			mainTabFolder.setSelection(index);
		}
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}