import { useState } from 'react';
import './App.css';
import AppMain from './view/AppMain';
import AppResult from './view/AppResult';
import AppSurvey from './view/AppSurvey';

function App() {
  const [page, setPage] = useState(1);

  const returnPage = () => {
    switch (page) {
      case 1:
        return <AppMain />;
      case 2:
        return <AppResult />;
      case 3:
        return <AppSurvey />;
      default:
        return <div>디폴트</div>;
    }
  };

  return (
    <div className="container">
      <button onClick={() => setPage(1)}>AppMain</button>
      <button onClick={() => setPage(2)}>AppResult</button>
      <button onClick={() => setPage(3)}>AppSurvey</button>
      <div>{returnPage()}</div>
    </div>
  );
}

export default App;
