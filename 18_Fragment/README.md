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




To use fragments to construct multi paged applications. These are top-3 libraries to build the 
navigation logics
- `Navigation`
- `BottomNavigationView`
- `ViewPager2`
