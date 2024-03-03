import './App.css'
import RightSide from './components/RigtSide/RightSide';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'; // Import Routes instead of BrowserRouter
import MainDash from './components/MainDash/MainDash';
import Sidebar from './components/Sidebar/Sidebar';
import FetchRoutes from "./components/Route/FetchRoutes";


function App() {
    return (
        <div className="App">
            <div className="AppGlass">
                <Sidebar />
                <Routes>
                    <Route path="/" exact element={<MainDash />} /> {/* Use element prop instead of component */}
                    <Route path="/dashboard" element={<MainDash />} />
                    <Route path="/right-side" element={<RightSide />} /> {/* Corrected the path */}
                    <Route path="/routes" component={FetchRoutes} />
                    {/* Add more routes here */}
                </Routes>
            </div>
        </div>
    );
}

export default App;
