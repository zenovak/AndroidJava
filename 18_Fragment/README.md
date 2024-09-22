## Fragments 
If you are familiar with single-paged applications for the web, fragments might be easier to 
understand that way. Fragments are composable/component like modules that can be inflated within
an activity. A sub-activity.

They have similar lifecycle calls as activities.
- `onCreate`
- `onDestroy`
- `onResume`

etc.

Some applications can have multiple pages. We can implement this with activity, however when  it
comes to implementing the navigation bar. you'll find that we need to declare the navigation panel 
in all those different pages.

What if instead we can package these UI layouts as reusable components. Kinda like how a single 
layout file is used to describe the UI for a RecyclerView item.

This is `fragment`. To design a multi-page application with a shared layout, the idea is to use
the main activity as the navigation bar, where the main content pages are different fragments that
can be called and swapped in place when a different page is requested

Very much like React or Vue components.

<br>

### The goal
In this example project, we will explore the different ways of creating multi-paged applications
using fragments and viewPager. The method of navigation will differ across examples, such as a tab
layout, a navigation drawer, and bottom navigation bar

Each example is implemented as an activity.


<br>

### When to use fragments vs activities
Fragments are used to create Reusable UI components that can assemble into a single page. In this 
sense we can follow a fragment-first approach.

However there are a few key areas where activities are preferred and vice versa:

Use fragments when:
- Need to share a single layout across multiple pages
- Need to create reusable UI components that are use-case generics (Numpads, map, date picker, etc)

Use an activity when:
- Need a page that can be started by an intent (share on Instagram, whatsapp, etc)
- Need a fresh set of application libraries


<br>

### Architecture and viewPager
`ViewPager2` is like `RecyclerView`, it requires an adapter to inflate the views for the fragment
pages.


To use ViewPager to construct multi paged applications with fragments. You will need to define:
- `ViewPager2` the View class that is responsible for displaying the pages.
- `Fragment` classes and their layout resources to represent each individual pages
- `FragmentStateAdapter` to initialize and inflate the Fragment page layout
- A UI layout library for the navigation


These are top UI components to build the navigation logics
- `TabLayout`
- `BottomNavigationView`

<br><br>

---
## Fragment Usage Examples


### Static Fragments
Fragments can be attached to a single activity statically. In this scenario fragments behaves more 
like reusable UI components. 

<br>

### ViewPager fragments
Fragments can be inflated and initialized by a `viewPager`'s adapter. The viewPager allows fragments
to be swiped into and out of view. It allows for the basis of multi-paged navigation. 

However, `ViewPager` does not come with its own tab or page indicator and requires additional 
UI components such as TabLayout to provide the navigation hints and buttons.

This example will be built upon to add UI navigation indicators.







<br><br>

---
## References

https://developer.android.com/guide/navigation/navigation-swipe-view-2

