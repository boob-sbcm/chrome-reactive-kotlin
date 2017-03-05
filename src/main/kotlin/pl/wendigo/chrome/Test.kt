package pl.wendigo.chrome

import io.reactivex.Flowable
import pl.wendigo.chrome.domain.page.NavigateRequest

class Test {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val api = RemoteChrome.connect("127.0.0.1", 9292, true)


            Flowable.merge(api.DOM.enable(), api.Page.enable(), api.CSS.enable())
                .lastOrError()
                .toFlowable()
                .flatMap {
                    api.Page.navigate(NavigateRequest(url = "http://allegro.pl"))
                }
                .flatMap { (frameId) ->
                    api.Page.onFrameStoppedLoading().filter {
                        (loadedFrameId) ->
                        loadedFrameId == frameId
                    }.take(1)
                }
            .subscribe({ println("Finished loading with event " + it);  }, {
              println("Got exception" + it)
            }, {
                api.close()
            })
        }
    }
}