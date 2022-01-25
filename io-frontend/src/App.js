import './App.scss';
import {Header} from "./components/Header/Header";
import {Main} from "./components/Main/Main";
import {Route, Routes, useNavigate,} from "react-router-dom";
import {BuildingForm} from "./components/BuildingForm/BuildingForm";
import {library} from '@fortawesome/fontawesome-svg-core'
import {faVectorSquare, faCube, faFire, faLightbulb} from "@fortawesome/free-solid-svg-icons";

library.add(faVectorSquare, faCube, faFire, faLightbulb)

function App() {
  return (
    <div className="App">
      <Header/>
        <Routes>
            <Route path={'/'} element={<Main/>}/>
            <Route path={'/new'} element={<BuildingForm/>}/>
        </Routes>
    </div>
  );
}

export default App;
