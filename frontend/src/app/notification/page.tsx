export default function Notification() {
    return(
        <div className="flex flex-col justify-center items-center p-24">
            <h1 className="font-bold text-4xl mb-8">Notifications</h1>
            <div className="w-full mb-4">
                <h2 className="font-bold">Assignments</h2>
            </div>
            <div className="w-full mb-4">
                <h2 className="font-bold">Updates</h2>
            </div>
            <div className="w-full mb-4">
                <h2 className="font-bold">Reminders</h2>
            </div>
        </div>
    );
}