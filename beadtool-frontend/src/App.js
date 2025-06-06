import React, { useState } from 'react';
import UploadForm from './components/UploadForm';
import BeadGrid from './components/BeadGrid';

function App() {
  const [grid, setGrid] = useState(null);

  return (
    <div>
      <h1>Bead Template Generator</h1>
      <UploadForm onResult={setGrid} />
      {grid && <BeadGrid grid={grid} />}
    </div>
  );
}

export default App;

//flow as followes 
//| Step | Action                                                             |
//| ---- | ------------------------------------------------------------------ |
//| 1    | `App` declares state with `useState(null)`                         |
//| 2    | `App` passes `setGrid` to `UploadForm` as `onResult`               |
//| 3    | User uploads image → `UploadForm` sends POST to backend            |
//| 4    | When backend returns grid, `onResult(data)` is called              |
//| 5    | `setGrid(data)` updates state → `App` re-renders                   |
//| 6    | `<BeadGrid grid={grid} />` is now visible and renders the template |
