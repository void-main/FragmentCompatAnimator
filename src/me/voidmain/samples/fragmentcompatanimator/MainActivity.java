package me.voidmain.samples.fragmentcompatanimator;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;

public class MainActivity extends SherlockFragmentActivity {
	private RoundedColourFragment frontFrag;
	private RoundedColourFragment backFrag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ActionBar ab = getSupportActionBar();
		ab.setHomeButtonEnabled(true);

		final int MARGIN = 16;
		frontFrag = new RoundedColourFragment(getResources().getColor(
				R.color.android_green), 1f, MARGIN, MARGIN, MARGIN, MARGIN);
		backFrag = new RoundedColourFragment(getResources().getColor(
				R.color.honeycombish_blue), 1f, MARGIN, MARGIN, MARGIN, MARGIN);
		
		backFrag.setCreatedListener(new RoundedColourFragment.ViewCreatedListener() {
			
			@Override
			public void onViewCreated() {
				View v = backFrag.getView();
				final ObjectAnimator invisToVis = ObjectAnimator.ofFloat(v, "rotationY",
    	                -90f, 0f);
    	        invisToVis.setDuration(300);
    	        invisToVis.setInterpolator(decelerator);
    			
    			invisToVis.start();
			}
		});

		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.add(R.id.root, frontFrag);
		ft.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	private Interpolator accelerator = new AccelerateInterpolator();
    private Interpolator decelerator = new DecelerateInterpolator();
    private void flipit() {
        ObjectAnimator visToInvis = ObjectAnimator.ofFloat(frontFrag.getView(), "rotationY", 0f, 90f);
        visToInvis.setDuration(300);
        visToInvis.setInterpolator(accelerator);
        visToInvis.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator anim) {
            	FragmentTransaction ft = getSupportFragmentManager()
    					.beginTransaction();
    			ft.replace(R.id.root, backFrag);
    			ft.commit();
            }
        });
        visToInvis.start();
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.add(R.id.root, frontFrag);
			ft.commit();
			flipit();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
