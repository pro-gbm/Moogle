import { useState } from "react";
import { Navigate, Route, Routes } from "react-router-dom";
import "./App.css";
import { routers } from "./router";

function App() {
  return (
    <div className="container">
      <Routes>
        {routers.map((router) => (
          <Route
            key={`${router.id}-${router.title}`}
            path={router.path}
            element={<router.component />}
          />
        ))}
        <Route path="/" element={<Navigate replace to="/main" />} />
      </Routes>
    </div>
  );
}

export default App;
