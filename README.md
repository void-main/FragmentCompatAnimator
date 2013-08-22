# Fragment Compatibility Animator Sample
*Animate compat fragment with Honeycomb Animation API*

## Why
Since honeycomb (API level 11), Google has introduced a new set of APIs to help developers build better app, including [Fragment](http://developer.android.com/guide/components/fragments.html) and [property animation](http://developer.android.com/guide/topics/graphics/prop-animation.html).

These new APIs are great, but they are not quite compatible with older devices, thus Google provided a [support library](http://developer.android.com/tools/support-library/index.html) to solve this problem.

While building my app, I'm trying to use the [compat fragment](http://developer.android.com/reference/android/support/v4/app/Fragment.html) to support as many devices as possible, meanwhile, I want to take advantage of new set of animation apis to create animation easier.

The [FragmentTransaction](http://developer.android.com/reference/android/support/v4/app/FragmentTransaction.html) class has a simple API named `setCustomAnimations()` to set the animation while switching fragments. But, sadly, when I tried to use the animator xml file (I mean, using property animation elements like `<objectAnimator>` in the animation xml) on Gingerbread emulator (with API level less than 11), the app simply crashed complaining it does not understand the `objectAnimator` sh*t, which means you have to give up on the new animation API with compat fragment.

No way!

That's why I've built this sample. If you are interested, I've written a [blog post](http://blog.voidmain.me/android/animator/fragment/2013/08/22/how-to-use-new-android-animation-api-for-compat-fragment.html) explaining how I work this whole thing out.

## Live Demo
To prove that IT IS POSSIBLE to use animator API with fragments, I'd better show you a demo first. The following demo is casted on Gingerbread (API level 9) emulator.
![Screenshot](fragment_compat_animator_demo.gif)

The green rounded rectange as well as the blue one are two fragments, whose code is extracted from [ActionBarSherlock](http://actionbarsherlock.com/)'s styled action bar demo. Once I clicked the `android.R.id.home` button on actionbar, the fragment starts to flip by changing the `rotationY` property.

## Read the code
If you happen to be interested in this topic, I strongly recommend you to read the code, it's easy and straight forward. When encountered problem, try to refer to my [blog post](http://blog.voidmain.me/android/animator/fragment/2013/08/22/how-to-use-new-android-animation-api-for-compat-fragment.html) for detailed explanation. If the problem is still there or, even better, you have some advice for me, fell free to contact me, the address is [voidmain1313113@gmail.com](mailto:voidmain1313113@gmail.com?subject=Something%20about%20Fragment%20Compatibilty%20Animator%20Sample...)

## Further plan
This is only a demo, the code is ugly and unorganized, I plan to build a simple util class to make using animator api for compat fragment even easier, so stay tuned, or star this project for further update.