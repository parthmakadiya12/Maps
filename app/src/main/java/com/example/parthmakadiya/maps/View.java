package com.example.parthmakadiya.maps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        TextView tv = (TextView)findViewById(R.id.txtName);
        EditText ed=(EditText)findViewById(R.id.editText);
        TextView em=(TextView) findViewById(R.id.txtML);
        ImageView im=(ImageView)findViewById(R.id.imageView);
        String demo="This is Demo Text and Demo Image.We Can Put Data Here . Its Not more import now because we can put it later on as we can get the Data.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\n" +
                "Why do we use it?\n" +
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\n" +
                "\n";
        em.setText(demo);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        String stuff = bundle.getString("stuff");
        if (stuff.equals("UMA")) {
            tv.setText("UMA Hostel");
            em.setText("xxxxxxxxxxxxxxxxxxxxxxx inside edit  xxxxxxxxxxxxxxxxxxxxxxxxx");
            im.setImageResource(R.drawable.u);


        }

        else if (stuff.equals("Hacker Here"))
        {
            imageView.setImageResource(R.drawable.u);
            tv.setText("Uma Hostel");
            em.setText("This is UMA Hostel.In here Marine Hostel also comes under the same shade.UMA Hostel has nice facilities with AC/NON-AC rooms.UMA hostel has 8-9 Wings. Every Wing has 29 Rooms.Peaceful atmosphere");
            im.setImageResource(R.drawable.u);

        }

        else if (stuff.equals("Memc Dept."))
        {
            imageView.setImageResource(R.drawable.mainb);
            //remove button when you free By PM.
            em.setText(Html.fromHtml("<p>Memc Dept. has CE-IT-EC-MARINE-AUTOMOBILE-Diploma Branches.New Building has Nice Arcitecture with great Branches. CE-IT and Marine are popular Braches of This Department.<br/>Our spirituous efforts are directed towards leading our student community to such an acme of technical excellence meeting the requirements of the industry, the nation and the globe at large. Nurturing an entirely different generation of students aiming at attaining technical expertise and utilizing the technical know-how in the service of mankind is at the root of our efforts. We have the following aims before us.<br/><ul class=\"TRS\"><li>To offer guidance, motivation and inspiration for full growth of hidden traits </li><li>To impart technical and need-based education by conducting elaborated training programs. </li><li>To shape and mould the personality of future generation </li><li>To construct fertile ground for adapting to dire challenges </li><li>To cultivate the feeling of belongingness amongst the faction of engineers </li></ul></p><br/><p align=\"center\"><h2>Important Links:-<br/><button><a align=\"center\" href=\"http://www.uvpce.ac.in/content/it-about\">IT Dept</a></button><br/><button><a href='http://www.uvpce.ac.in/content/ce-about'>CE Dept</a></button><br/><button><a href='http://www.uvpce.ac.in/content/ec-about'>EC Dept</a></button><br/><button><a href='http://www.uvpce.ac.in/content/mca-about'>MCA About</a></button><br/><button><a href='http://www.uvpce.ac.in/content/marine-about'>Marine</a></button><br/><h2></p>"));
            tv.setText("Main Building");
            em.setMovementMethod(LinkMovementMethod.getInstance());
            im.setImageResource(R.drawable.mainb);
        }
        else if (stuff.equals("MTech Building"))
        {
            imageView.setImageResource(R.drawable.mba);
            //remove button when you free By PM.
            em.setText(Html.fromHtml("<p><h1>CENTRE FOR MANAGEMENT STUDIES AND RESEARCH</h1>\n" +
                    "\n" +
                    "The Centre for Management Studies and Research, Ganpat University is dedicated to develop and administer management courses to prepare management professionals to meet requirements of industry, viz, Agribusiness, Pharmaceuticals, Financial services, International Business etc. with the approval of Faculty of Management Studies, the Centre offers autonomous programs of Ganpat University in the area of Management. The Centre offers Bachelor and Master Programs in upcoming fields of Management. The Centre has full-time faculty for conducting program syllabus along with inputs by visiting and guest faculty from leading academic institutions and industry on continuous basis.\n" +
                    " \n" +
                    "The Centre for Management Studies and Research was established with the aim of fine-tuning the academic curriculum to meet the ever dynamic requirements of the industry and facilitate knowledge sharing between the two. The centre aims at organizing various collaborative programs to systematize and catalyze the various joint activities between Industry and the Institute.<br/><button><a href='http://www.cms.gnu.ac.in/content/about-us'>MBA</a></button><br/><h2></p>"));
            tv.setText("MBA Building");
            em.setMovementMethod(LinkMovementMethod.getInstance());
            im.setImageResource(R.drawable.mba);
        }
        else if (stuff.equals("Canteen"))
        {
            imageView.setImageResource(R.drawable.cant);
            //remove button when you free By PM.
            em.setText(Html.fromHtml("<p><h1>Canteen / Cafeteria Here</h1>\n" +
                    "\n" +
                    "Caneen Here . We have Provided The Best Services and Food Avalible<br/><h2></p>"));
            tv.setText("MBA Building");
            em.setMovementMethod(LinkMovementMethod.getInstance());
            im.setImageResource(R.drawable.cant);
        }


        else if (stuff.equals("New Building"))
        {
            imageView.setImageResource(R.drawable.newb);
            //remove button when you free By PM.
            em.setText(Html.fromHtml("<p>New Building has CE-IT-EC-MARINE-AUTOMOBILE-Diploma Branches.New Building has Nice Arcitecture with great Branches. CE-IT and Marine are popular Braches of This Department.<br/>Our spirituous efforts are directed towards leading our student community to such an acme of technical excellence meeting the requirements of the industry, the nation and the globe at large. Nurturing an entirely different generation of students aiming at attaining technical expertise and utilizing the technical know-how in the service of mankind is at the root of our efforts. We have the following aims before us.<br/><ul class=\"TRS\"><li>To offer guidance, motivation and inspiration for full growth of hidden traits </li><li>To impart technical and need-based education by conducting elaborated training programs. </li><li>To shape and mould the personality of future generation </li><li>To construct fertile ground for adapting to dire challenges </li><li>To cultivate the feeling of belongingness amongst the faction of engineers </li></ul></p><br/><p align=\"center\"><h2>Important Links:-<br/><button><a align=\"center\" href=\"http://www.uvpce.ac.in/content/it-about\">IT Dept</a></button><br/><button><a href='http://www.uvpce.ac.in/content/ce-about'>CE Dept</a></button><br/><button><a href='http://www.uvpce.ac.in/content/ec-about'>EC Dept</a></button><br/><button><a href='http://www.uvpce.ac.in/content/mca-about'>MCA About</a></button><br/><button><a href='http://www.uvpce.ac.in/content/marine-about'>Marine</a></button><br/><h2></p>"));
            tv.setText("New Building");
            em.setMovementMethod(LinkMovementMethod.getInstance());
            im.setImageResource(R.drawable.newb);
        }
        else if (stuff.equals("CE-IT"))
        {
            imageView.setImageResource(R.drawable.newb);
            em.setText("CE IT department.");
            tv.setText("CE IT Dept.");

            im.setImageResource(R.drawable.newb);
        }
        else if (stuff.equals("CIVIL-EE"))
        {
            tv.setText("CIVIL EE DEPT");
            im.setImageResource(R.drawable.u);
        }

        else if (stuff.equals("ME-MC"))
        {
            tv.setText("ME MC DEPT");
            im.setImageResource(R.drawable.u);
        }
        else if (stuff.equals("UB"))
        {
            imageView.setImageResource(R.drawable.staff);
            //remove button when you free By PM.
            em.setText(Html.fromHtml("<p><button><a href='http://www.uvpce.ac.in/content/marine-about'>Staff Quarters</a></button><br/><h2></p>"));
            tv.setText("Staff Quarters");
            em.setMovementMethod(LinkMovementMethod.getInstance());
            im.setImageResource(R.drawable.staff);
        }
        else if (stuff.equals("Shopping Center"))
        {
            imageView.setImageResource(R.drawable.staff);
            //remove button when you free By PM.
            em.setText(Html.fromHtml("<p>Here you can get quality food <button><a href='http://www.uvpce.ac.in/content/marine-about'>Staff Quarters</a></button><br/><h2></p>"));
            tv.setText("Shopping Center");
            em.setMovementMethod(LinkMovementMethod.getInstance());
            im.setImageResource(R.drawable.staff);
        }

        else if (stuff.equals("University Building"))
        {
            imageView.setImageResource(R.drawable.uni);
            //remove button when you free By PM.
            em.setText(Html.fromHtml("<p>Ganpat University as a well reputed State Private University established in 2005 through the State Legislative act no 19 of 2005, Government of Gujarat and recognized by the UGC under the section 2(f) of the UGC Act, 1956 having campus spread over more than 300 acres of land with world class infrastructure and more than 10,000 students on campus. The University offers Diplomas, Under Graduate, Post – Graduate and Research Programs under the Faculties of Engineering and Technology, Pharmacy, Management, Computer Applications, Sciences, Education, Humanities and Social Science and Human Potential Development. Ganpat University and the township of Ganpat Vidyanagar, a high-tech education campus is a joint initiatives; purely for philanthropy; of a large number of industrialists and technocrats, noble farmers and affluent businessmen; having a mission of “Social Upliftment through Education”<button><a href='http://www.ganpatuniversity.ac.in/content/about-university'>University</a></button><br/><h2></p>"));
            tv.setText("University Building");
            em.setMovementMethod(LinkMovementMethod.getInstance());
            im.setImageResource(R.drawable.uni);
        }
        else if (stuff.equals("B.S. Patel Polytechnic"))
        {
            imageView.setImageResource(R.drawable.bsp);
            //remove button when you free By PM.
            em.setText(Html.fromHtml("<p>B. S. Patel Polytechnic, established in August -1999, is the first self-financed engineering institute in North Gujarat, imparting High-tech Diploma Courses in Engineering. This Institute is approved by All India Council For Technical Education (AICTE), New Delhi and is affiliated to Gujrat Technological University (GTU). The institute, spread over 25 Acres of land, is located in Ganpat Vidyanagar Campus. The institute runs in ultra-modern Building of Architectural splendor, housing classrooms, seminar halls, drawing halls, Conference room, Library, Computer laboratories, well-equipped different departmental laboratories and an administrative block.<button><a href='http://www.bspp.ac.in/index.php?file=contain&id=1'>University</a></button><br/><h2></p>"));
            tv.setText("B.S. Patel Polytechnic");
            em.setMovementMethod(LinkMovementMethod.getInstance());
            im.setImageResource(R.drawable.bsp);
        }
        else if (stuff.equals("staff quarters"))
        {
            imageView.setImageResource(R.drawable.staff);
            //remove button when you free By PM.
            em.setText(Html.fromHtml("<p><button><a href='http://www.bspp.ac.in/index.php?file=contain&id=1'>Staff Quarters</a></button><br/><h2></p>"));
            tv.setText("Staff Quarters");
            em.setMovementMethod(LinkMovementMethod.getInstance());
            im.setImageResource(R.drawable.staff);
        }
//staff quarters

        else {
            imageView.setImageResource(R.drawable.uvpce);
            stuff = bundle.getString("stuff");
            em.setText(demo);//now its calling this
            tv.setText(stuff);
        }
    }
}
