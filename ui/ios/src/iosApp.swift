import SwiftUI
import kotlin

struct RootView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        ViewControllerKt.ViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
    }
}


@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            RootView()
                .ignoresSafeArea(.all)
        }
    }
}