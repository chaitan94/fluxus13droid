package com.IITI.fluxus13;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class EventDialog extends FragmentActivity implements OnClickListener {

	TextView title, description;
	String name, detail;
	Button remind, close, reg, rul, next, prev;
	int evtType, evtNum;
	String[] pro, cult, tech, inf, mara, work;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event);
		Bundle gotBasket = getIntent().getExtras();
		evtType = gotBasket.getInt("typeEvent");
		evtNum = gotBasket.getInt("key");

		title = (TextView) findViewById(R.id.tvTitle);
		description = (TextView) findViewById(R.id.tvDescription);
		remind = (Button) findViewById(R.id.bSetRem);
		close = (Button) findViewById(R.id.bCloseEventDialog);
		reg = (Button) findViewById(R.id.bReg);
		rul = (Button) findViewById(R.id.bRules);
		next = (Button) findViewById(R.id.bNextEvent);
		prev = (Button) findViewById(R.id.bPrevEvent);

		pro = getResources().getStringArray(R.array.proEvents);
		cult = getResources().getStringArray(R.array.cultEvents);
		tech = getResources().getStringArray(R.array.techEvents);
		inf = getResources().getStringArray(R.array.informalEvents);
		mara = getResources().getStringArray(R.array.maraEvents);
		work = getResources().getStringArray(R.array.workshops);

		remind.setOnClickListener(this);
		close.setOnClickListener(this);
		reg.setOnClickListener(this);
		rul.setOnClickListener(this);
		prev.setOnClickListener(this);
		next.setOnClickListener(this);

		setNameAndDetail(evtType, evtNum);
	}

	protected void setNameAndDetail(int evtType, int evtNum) {
		if (evtNum == 0) {
			prev.setVisibility(View.INVISIBLE);
		} else {
			prev.setVisibility(View.VISIBLE);
		}
		switch (evtType) {
		case 0:
			name = pro[evtNum];
			switch ((evtNum)) {
			case 0:
				detail = "Get ready to clutch your sides and tear up at a night of wit, humour and jest as the one and only, ________ forces you to forget all your pains and worries and double up with laughter. A night of giggles and guffaws beckons you...!!!";
				break;
			case 1:
				detail = "All the guys and girls in the crowd let your hair loose and head-bang to the rhythm of the beats as the music builds you up to a crescendo of fun and joy.";
				break;
			case 2:
				detail = "Get on the dance floor it's time to break free...the stage's set, the music's great, let your body follow the rhythms, and sway the night away. So let down your guard, shed your inhibitions and dance like it's the last night of your life!!!";
				next.setVisibility(View.INVISIBLE);
				break;
			}
			break;
		case 1:
			name = cult[evtNum];
			switch ((evtNum)) {
			case 0:
				detail = "For all those who have been following the Israel-Palestinian conflict more than the latest FIFA 13 release, who think they could have done a better job if they were in either the Israel government or the Palestinian Liberation Organization or better still a delegate in the United Nations itself, here comes an opportunity knocking at your doorsteps. Participate in the Model United Nations, play-act the role of a delegate of the nations and try to work out a solution to the raging conflict to win exciting prizes.";
				break;
			case 1:
				detail = "Solve the riddles, find answers to the witty questions and prove yourself to be intelligent enough for the actual Treasure Hunt. Now here is where all the fun begins - clues will be spread all over the city, and all you have got is your wit and a few bucks; one clue leading to another and ultimately to the treasure. But the fun doesn't end there; other than the treasure itself, we have prizes and merchandise worth Rs. 3000 up for grabs for who unearths the treasure first!";
				break;
			case 2:
				detail = "Yeh prize mujhe dede fluxus! Is it the 'gabbarsingh' inside you dying to come out! Then bring 'him' to the drama competition hosted by IIT Indore, where some of the best actors will act to perfection, live to the emotion and compete to acquire the top position..let's find who takes away the best actor/actress award at the 3rd IITI academy awards ceremony!!!";
				break;
			case 3:
				detail = "Let us get your adrenaline pumped up. Hold your breath for the most spectacular and dangerous stunts that will surpass your imagination";
				break;
			case 4:
				detail = "The flavor of the stage, the panic of performance, the excitement and anxiety, the cheers and applause as you bow down to the audience...is what every dancer's dream. Are you one of those dancing freaks who can't stop tapping their feet whenever they hear the beats and share this dream, let Fluxus'13 bring it to life. So come, groove into ecstasy on the angelic beats at Fluxus and sway in rhythm with some groovy and enthralling moves. Prove your mettle while competing with some of the best in the business.";
				break;
			case 5:
				detail = "Quizooka is back...with some extremely thought provoking questions which will tease your brain and will put your wits in a quandary. With many categories of questions from 'identify-the-picture' to 'rapid fire', Quizooka will test the boundaries of your patience. Come and challenge yourself in this colossal quagmire of questions hosted by IIT Indore. It's time for your inner quiz wizard to wake up!!!";
				next.setVisibility(View.INVISIBLE);
				break;
			}
			break;
		case 2:
			name = tech[evtNum];
			switch ((evtNum)) {
			case 0:
				detail = "Exquisite structures are conceived only when a mind brimming with creativity gets the balance between beauty and design correct. Challenge the budding architect in you to see if he is capable of crafting utmost beauty into a structure while conserving its ability to withstand thumps and shocks!";
				break;
			case 1:
				detail = "A designer knows he has achieved perfection not when there is nothing left to add, but when there is nothing left to take away. Can you can achieve the highest level of optimization and make your circuit stand out from the others while performing the same function?";
				break;
			case 2:
				detail = "An international coding contest in which participants has to design and code an efficient algorithm for the given problem.";
				break;
			case 3:
				detail = "You are trapped in a deep dungeon and you must escape! Do not get us wrong here; this game has nothing to do with how strong your legs are. Design an eloquent bot that uses any means you can think of to escape out of a pit without touching its walls. Feel the heat as the height of the pit increases with the level.";
				break;
			case 4:
				detail = "Do you have the brilliance to outsmart the Wright brothers of this era? This competition requires one to develop a glider that has no motors or power supply. Put your aero modelling skills at test and design an aircraft that can cover a long distance after being given an initial thrust. Restrictions on dimensions will further complicate the problem! So come up with a raptor and discover the aero scientist within you.";
				break;
			case 5:
				detail = "Do you dare to test your robo hounds metal in this blood thirsty war of speed and accuracy? This line follower robot competition gives a challenge to the tech-savvy minds to create their own autonomous bots that can follow a prescribed path in the least possible time. Mind you, there will be complex spiral paths and the robos will scurry simultaneously with other legion bots in parallel paths. The photo finish endings will give you the adrenaline rush of your life!";
				break;
			case 6:
				detail = "Remember those high velocity motorboat chases across the waters of Venice often depicted in Hollywood? Robo-Aquatics aims to capture the thrill of such acts and pack all of it into a contest so intense that even a split second can be the difference between winning and losing.";
				break;
			case 7:
				detail = "Accuracy, Speed, and Span! That is what M-Armada is about! In this event, contestants will be required to design a missile with a certain payload, whose accuracy and range will be juxtaposed against rivals! So what are you waiting for? Your nearest Arsenal awaits you!";
				break;
			case 8:
				detail = "Advanced robotics and Sumo wrestling are pretty common in Japan. Mix them up, and you get Robo Sumo-your mini trip to Japan! In this event, contestants will be required to design a SUMO robot, and your objective would be to push the other robot out of the arena! So.. let the games begin!";
				break;
			case 9:
				detail = "For every Tiger in the Woods, time has come to realize a sci-fi fantasy. On an artificial golf course, autonomous bots will try to outscore each other. It is an Image Processing based event where teams will use a live camera feed of the arena. The bots will decide their course of action to put maximum number of balls in holes in limited time. So mix your sporting and technical ideas and develop a golfer robo to assert your technical supremacy over others.";
				break;
			case 10:
				detail = "If you think that all those hours you spent gaming were a waste of time, think again! This is your chance to prove just how good a gamer you are!!";
				next.setVisibility(View.INVISIBLE);
				break;
			}
			break;
		case 3:
			name = inf[evtNum];
			switch ((evtNum)) {
			case 0:
				detail = "Put aside your books and start zooming into the world with your camera lens. Hurry before time runs out: start now - Click! Click! Click!";
				break;
			case 1:
				detail = "Go back to your childhood, grab a kite and soar high. Innovate your kite show your might and thrill up the fight!!!";
				break;
			case 2:
				detail = "The JEE just got interesting with a mix of exciting questions and even more interesting options this JEE will assure you loads of fun.";
				break;
			case 3:
				detail = "How would you feel left alone among people you can't communicate with? A word would probably feel the same way if left in company of nine other words it has no link with. Help the words communicate by finding links and connecting them together in a piece of literature.";
				break;
			case 4:
				detail = "It's more interesting than a treasure hunt, the treasure being a word. Get a grip on your knowledge of the English language and exercise your brain to hunt this word from the cache of the lexis, that's all you require to be the champion.";
				break;
			case 5:
				detail = "Competing individually through the three rounds- written test, rapid fire and finally some very tough words-you would surely be left spellbound at the vastness of English and puzzled at how even easy words can confuse you with pronunciation.";
				next.setVisibility(View.INVISIBLE);
				break;
			}
			break;
		case 4:
			name = mara[evtNum];
			switch ((evtNum)) {
			case 0:
				detail = "In a society that claims to be advancing rapidly on all counts right from planning missions to the Mars to the development of nuclear energy, incidents like brutal rapes, molestation of women bring us back to square one. Have we just progressed materially? Haven't we achieved anything morally? This is the time when we must make the people realize that a woman is not a toy but the mother of all the creations. It is with this goal in mind that we are organizing the marathon themed on 'Respect for Women'. Being on the highest level of intelligence it is our moral and humane responsibly to stand up for the causes of women and exhibit our whole-hearted support by participating in the marathon.";
				next.setVisibility(View.INVISIBLE);
				break;
			}
			break;
		case 5:
			name = work[evtNum];
			switch ((evtNum)) {
			case 0:
				detail = "Ever wondered how 400Kmph speed demons are built? How a slightest configuration change can help you milk another 10-20Kmph from your car and help you set a new record? Well then AutoSPARK is just the thing for you! From aerodynamic design to suspensions, automotive parts will be explained with their contributions towards the ultimate driving machine. If you are an Automotive savvy then this is the place to be!";
				break;
			case 1:
				detail = "Cyber security is of utmost importance in the contemporary world. Sensitive information is often exchanged through the internet, and is prone to theft. Enterprise or Individual, the risk is always large, and HackIN will prevent you from being compromised. From Google database hacking to OS passkey bypassing, Emails to hacking via USB, HackIN is going to make sure that you are aware of how cyber threats arise, so you may always be ready for them. Moreover, bragging rights complement this course, as you may always show off the skills you have honed ;)";
				break;
			case 2:
				detail = "Remember those paper gliders that you made when you were a child? Now it's time to give Wings to your dreams, and Wings has you covered! Nitty-gritties of Aerodynamics, Gliders, and even RC controlled planes, will be dealt with so that you can SWOOOSH past your competition and show who is boss! If you want to hold the current mini aircraft speed record, then this course will give you just what you need, So... CHOCKS AWAY!";
				break;
			case 3:
				detail = "Gentlemen! Start your engines! Racing heritage associated with legendary cars such as the McLaren F1 GTR, The Shelby Daytona Coupe, The Porsche 917 Le Mans, has actually inspired millions to recreate these legends in the contemporary world... and the result was Radio Controlled Racing cars! And that is what Full Throttle is all about. Full Throttle will give you the opportunity to indulge into the RC Racing culture, and will help you build your ultimate race car, and even give you a chance to witness the awesomeness of Nitro RC cars, which are capable of leaving a BIG lot of road cars in the dust!";
				next.setVisibility(View.INVISIBLE);
				break;
			}
			break;
		}
		title.setText(name);
		description.setText("    " + detail);
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSetRem:
			Calendar beginTime = Calendar.getInstance();
			beginTime.set(2013, 2, 15, 7, 30);
			Calendar endTime = Calendar.getInstance();
			endTime.set(2013, 2, 15, 11, 30);
			Intent set = new Intent(Intent.ACTION_INSERT)
					.setData(Events.CONTENT_URI)
					.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
							beginTime.getTimeInMillis())
					.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
							endTime.getTimeInMillis())
					.putExtra(Events.TITLE, name)
					.putExtra(Events.DESCRIPTION, detail)
					.putExtra(Events.EVENT_LOCATION, "IIT Indore")
					.putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY)
					.putExtra(Intent.EXTRA_EMAIL, "bkchaitan94@gmail.com");
			startActivity(set);
			break;
		case R.id.bCloseEventDialog:
			finish();
			break;
		case R.id.bReg:
			// Hypothetical link
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.fluxus.in/register")));
			break;
		case R.id.bRules:
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.fluxus.in/" + name)));
			break;
		case R.id.bPrevEvent:
			evtNum--;
			setNameAndDetail(evtType, evtNum);
			if (next.isShown()) {

			} else {
				next.setVisibility(View.VISIBLE);
			}
			break;
		case R.id.bNextEvent:
			evtNum++;
			setNameAndDetail(evtType, evtNum);
			break;
		}
	}

}
